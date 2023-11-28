package uk.co.harnick.bulwark.core.settings.domain.model.security

import uk.co.harnick.bulwark.core.settings.domain.model.EnumSettingValue
import uk.co.harnick.bulwark.core.util.BuildIdentifiers.Desktop
import uk.co.harnick.bulwark.core.util.bulwarkBuild

enum class SecurityGateValue(
    override val label: String,
    val isSupported: Boolean = true
) : EnumSettingValue {
    Companion(label = "Bulwark app", isSupported = (bulwarkBuild == Desktop)),
    None(label = "None"),
    Password(label = "Password"),
    Pin(label = "PIN")
}
