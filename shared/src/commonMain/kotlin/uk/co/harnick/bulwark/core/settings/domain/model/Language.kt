package uk.co.harnick.bulwark.core.settings.domain.model

enum class Language(override val label: String) : EnumSettingValue {
    en_GB(label = "English (British)"),
    en_US(label = "English (American)")
}
