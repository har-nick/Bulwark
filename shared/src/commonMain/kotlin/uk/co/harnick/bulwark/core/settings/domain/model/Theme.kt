package uk.co.harnick.bulwark.core.settings.domain.model

enum class Theme(override val label: String) : EnumSettingValue {
    Auto(label = "Follow system theme"),
    Dark(label = "Dark"),
    Light(label = "Light")
}
