package com.racso.rickandmorty.utils

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview




@Preview(device = Devices.PIXEL_3_XL, showBackground = true, name = "LightPreview")
@Preview(device = Devices.PIXEL_3_XL, uiMode = UI_MODE_NIGHT_YES, name = "DarkPreview")
annotation class CustomPreview