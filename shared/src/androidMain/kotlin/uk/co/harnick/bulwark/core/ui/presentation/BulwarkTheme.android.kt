package uk.co.harnick.bulwark.core.ui.presentation

import android.app.Activity
import android.app.WallpaperManager
import android.app.WallpaperManager.FLAG_SYSTEM
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.O_MR1
import android.os.Build.VERSION_CODES.S
import androidx.annotation.RequiresApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.materialkolor.AnimatedDynamicMaterialTheme
import com.materialkolor.PaletteStyle
import java.security.InvalidParameterException
import uk.co.harnick.bulwark.core.settings.domain.model.Theme.Auto
import uk.co.harnick.bulwark.core.settings.domain.model.Theme.Dark
import uk.co.harnick.bulwark.core.settings.domain.model.Theme.Light
import uk.co.harnick.bulwark.core.settings.domain.model.display.DisplaySettings

// TODO: Check permissions for getSeedColorByImage

actual object BulwarkTheme {
    @RequiresApi(O_MR1)
    @Composable
    private fun getSeedColorByWallpaperColors(wallpaperManager: WallpaperManager): Color {
        val wallpaperColorArgb =
            wallpaperManager.getWallpaperColors(FLAG_SYSTEM)?.primaryColor?.toArgb()

        return wallpaperColorArgb
            ?.let { Color(it) }
            ?: throw InvalidParameterException("Wallpaper colors is null")
    }

//    @SuppressLint("MissingPermission")
//    @Composable
//    private fun getSeedColorByImage(wallpaperManager: WallpaperManager): Color {
//        val wallpaperImage = wallpaperManager.fastDrawable
//        val dominantColorState = rememberDominantColorState()
//        LaunchedEffect(wallpaperImage) {
//            if (wallpaperImage != null) {
//                val wallpaperBitmap = Bitmap.createBitmap(
//                    wallpaperImage.intrinsicWidth,
//                    wallpaperImage.intrinsicHeight,
//                    Bitmap.Config.ARGB_8888
//                ).asImageBitmap()
//                dominantColorState.updateFrom(wallpaperBitmap)
//            }
//        }
//        return dominantColorState.color
//    }

    @Composable
    private fun ThemeBySeedColor(
        seedColor: Color,
        useDarkTheme: Boolean,
        palette: PaletteStyle,
        content: @Composable () -> Unit
    ) {
        AnimatedDynamicMaterialTheme(seedColor, useDarkTheme, palette) {
            Surface { content() }
        }
    }

    @RequiresApi(S)
    @Composable
    private fun MaterialYou(useDarkTheme: Boolean, content: @Composable () -> Unit) {
        val localContext = LocalContext.current
        val materialYouColorScheme = when (useDarkTheme) {
            true -> dynamicDarkColorScheme(localContext)
            false -> dynamicLightColorScheme(localContext)
        }

        MaterialTheme(materialYouColorScheme) {
            Surface { content() }
        }
    }

    @RequiresApi(O_MR1)
    @Composable
    private fun MaterialYouByWallpaperColors(
        useDarkTheme: Boolean,
        content: @Composable () -> Unit
    ) {
        val localContext = LocalContext.current
        val wallpaperManager = WallpaperManager.getInstance(localContext)
        val seedColor = getSeedColorByWallpaperColors(wallpaperManager)

        AnimatedDynamicMaterialTheme(seedColor, useDarkTheme) {
            Surface { content() }
        }
    }

    @Composable
    actual operator fun invoke(
        displaySettings: DisplaySettings,
        content: @Composable () -> Unit
    ) {
        val view = LocalView.current
        val window = (view.context as Activity).window

        window.statusBarColor = Color.Transparent.toArgb()
        window.navigationBarColor = Color.Transparent.toArgb()

        val isSystemInDarkTheme = isSystemInDarkTheme()

        val useDarkTheme = when (displaySettings.theme.value) {
            Dark -> true
            Light -> false
            Auto -> isSystemInDarkTheme
        }

        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !useDarkTheme

        val materialYouEnabled = when {
            (SDK_INT >= S) -> displaySettings.materialYou.value
            else -> displaySettings.materialYouIsh.value
        }

        if (!materialYouEnabled) {
            ThemeBySeedColor(
                seedColor = displaySettings.seedColor.value,
                useDarkTheme = useDarkTheme,
                palette = displaySettings.palette.value.style,
                content = content
            )
        } else {
            when {
                (SDK_INT >= S) -> MaterialYou(useDarkTheme, content)

                (SDK_INT >= O_MR1) -> MaterialYouByWallpaperColors(useDarkTheme, content)

                else -> {
                    ThemeBySeedColor(
                        seedColor = displaySettings.seedColor.value,
                        useDarkTheme = useDarkTheme,
                        palette = displaySettings.palette.value.style,
                        content = content
                    )
                }

//                (SDK_INT <= O) -> {
//                    val seedColor = getSeedColorByImage(wallpaperManager)
//                    return AnimatedDynamicMaterialTheme(seedColor, useDarkTheme) {
//                        Surface { content() }
//                    }
//                }
            }
        }
    }
}