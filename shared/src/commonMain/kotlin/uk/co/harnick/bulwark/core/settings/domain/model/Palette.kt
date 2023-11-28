package uk.co.harnick.bulwark.core.settings.domain.model

import com.materialkolor.PaletteStyle

enum class Palette(override val label: String, val style: PaletteStyle) : EnumSettingValue {
    Content(label = "Content", style = PaletteStyle.Content),
    Expressive(label = "Expressive", style = PaletteStyle.Expressive),
    Fidelity(label = "Fidelity", style = PaletteStyle.Fidelity),
    FruitSalad(label = "Fruit Salad", style = PaletteStyle.FruitSalad),
    Monochrome(label = "Monochrome", style = PaletteStyle.Monochrome),
    Neutral(label = "Neutral", style = PaletteStyle.Neutral),
    TonalSpot(label = "Tonal Spot", style = PaletteStyle.TonalSpot),
    Vibrant(label = "Vibrant", style = PaletteStyle.Vibrant),
    Rainbow(label = "Rainbow", style = PaletteStyle.Rainbow)
}
