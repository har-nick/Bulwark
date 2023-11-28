package uk.co.harnick.bulwark.core.settings.domain.model.display

import uk.co.harnick.bulwark.core.settings.domain.model.Setting

expect class MaterialYouSetting(value: Boolean = false) : Setting<Boolean>
