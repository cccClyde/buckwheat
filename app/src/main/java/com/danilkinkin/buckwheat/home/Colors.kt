package com.danilkinkin.buckwheat.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danilkinkin.buckwheat.ui.BuckwheatTheme
import com.danilkinkin.buckwheat.ui.ThemeMode
import com.danilkinkin.buckwheat.ui.colorGood
import com.danilkinkin.buckwheat.util.combineColors
import com.danilkinkin.buckwheat.util.harmonize
import com.danilkinkin.buckwheat.util.toPalette

@Composable
fun Colors() {
    val context = LocalContext.current
    val theme = context.appTheme

    fun switchTheme(mode: ThemeMode) {
        context.appTheme = mode
    }

    Row(
        Modifier.statusBarsPadding()
    ) {
        Column {
            Color(MaterialTheme.colorScheme.surface)
            Color(MaterialTheme.colorScheme.surfaceVariant)
            Color(MaterialTheme.colorScheme.background)
            Color(MaterialTheme.colorScheme.primary)
            Color(MaterialTheme.colorScheme.error)
            Color(MaterialTheme.colorScheme.errorContainer)
            Color(MaterialTheme.colorScheme.inversePrimary)
            Color(MaterialTheme.colorScheme.inverseSurface)
            Color(MaterialTheme.colorScheme.primaryContainer)
            Color(MaterialTheme.colorScheme.secondary)
            Color(MaterialTheme.colorScheme.secondaryContainer)
            Color(MaterialTheme.colorScheme.tertiary)
            Color(MaterialTheme.colorScheme.tertiaryContainer)
        }
        Column {
            Color(
                MaterialTheme.colorScheme.surface
            )
            Color(
                combineColors(
                    MaterialTheme.colorScheme.surfaceVariant,
                    MaterialTheme.colorScheme.surface,
                    0.56F
                ),
                combineColors(
                    MaterialTheme.colorScheme.onSurfaceVariant,
                    MaterialTheme.colorScheme.onSurface,
                    0.56F
                )
            )
            Color(
                combineColors(
                    MaterialTheme.colorScheme.surface,
                    MaterialTheme.colorScheme.surfaceVariant,
                    0.96F,
                ),
                combineColors(
                    MaterialTheme.colorScheme.onSurface,
                    MaterialTheme.colorScheme.onSurfaceVariant,
                    0.96F,
                )
            )
        }
        Column {
            Color(colorGood)

            val harmonizedColor = toPalette(harmonize(colorGood))

            Color(harmonizedColor.main, harmonizedColor.onMain)
            Color(harmonizedColor.surface, harmonizedColor.onSurface)
            Color(harmonizedColor.container, harmonizedColor.onContainer)
        }
        Column {
            Switch(
                checked = theme === ThemeMode.NIGHT,
                onCheckedChange = {
                    switchTheme(if (it) ThemeMode.NIGHT else ThemeMode.SYSTEM)
                }
            )
            Text(text = "$theme")
        }
    }
}

@Composable
fun Color(color: Color, contentColor: Color = contentColorFor(color)) {
    Box(
        Modifier
            .background(color)
            .size(56.dp)
            .border(1.dp, Color.Black)
    ) {
        Text(
            text = String.format("#%06x", color.toArgb() and 0xFFFFFF),
            color = contentColor
        )
    }
}

@Preview
@Composable
private fun Preview() {
    BuckwheatTheme(dynamicColor = false) {
        Colors()
    }
}