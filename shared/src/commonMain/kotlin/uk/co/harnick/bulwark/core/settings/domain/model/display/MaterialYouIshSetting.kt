package uk.co.harnick.bulwark.core.settings.domain.model.display

import uk.co.harnick.bulwark.core.settings.domain.model.Setting

expect class MaterialYouIshSetting(value: Boolean = false) : Setting<Boolean>
