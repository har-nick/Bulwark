package uk.co.harnick.bulwark.core.settings.presentation

import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uk.co.harnick.bulwark.common.di.IODispatcher
import uk.co.harnick.bulwark.core.settings.domain.model.Setting
import uk.co.harnick.bulwark.core.settings.domain.model.SettingCollection
import uk.co.harnick.bulwark.core.settings.domain.model.display.DisplaySettings
import uk.co.harnick.bulwark.core.settings.domain.model.general.GeneralSettings
import uk.co.harnick.bulwark.core.settings.domain.model.security.SecuritySettings
import uk.co.harnick.bulwark.core.settings.domain.repository.SettingsRepo
import uk.co.harnick.bulwark.core.settings.domain.usecase.SettingsUseCases
import uk.co.harnick.bulwark.core.settings.presentation.SettingsEvent.ResetSettings
import uk.co.harnick.bulwark.core.settings.presentation.SettingsEvent.UpdateSetting
import uk.co.harnick.bulwark.core.ui.presentation.StatefulViewModel

class SettingsViewModel(
    private val ioDispatcher: IODispatcher,
    private val repo: SettingsRepo,
    private val useCases: SettingsUseCases
) : StatefulViewModel<SettingsState, SettingsEvent>(SettingsState()) {
    override fun onEvent(event: SettingsEvent) {
        when (event) {
            ResetSettings -> vmScope.launch(ioDispatcher) { repo.resetSettings() }

            is UpdateSetting<*> ->
                updateSetting(event.targetCollection, event.targetSetting, event.newValue)
        }
    }

    private fun updateSetting(
        targetCollection: SettingCollection,
        targetSetting: Setting<out Any>,
        newValue: Any
    ) {
        when (targetCollection) {
            is DisplaySettings -> useCases.saveDisplaySetting(
                state.value.displaySettings,
                targetSetting,
                newValue
            )

            is GeneralSettings -> useCases.saveGeneralSetting(
                state.value.generalSettings,
                targetSetting,
                newValue
            )

            is SecuritySettings -> useCases.saveSecuritySetting(
                state.value.securitySettings,
                targetSetting,
                newValue
            )
        }
    }

    // TODO: Add catch snackbar
    init {
        useCases.getSettingsAsState(vmContext + ioDispatcher)
            .onEach { stateEmission ->
                mutableState.update { oldState ->
                    oldState.copy(
                        displaySettings = stateEmission.displaySettings,
                        generalSettings = stateEmission.generalSettings,
                        securitySettings = stateEmission.securitySettings
                    )
                }
            }
            .launchIn(vmScope)
    }
}
