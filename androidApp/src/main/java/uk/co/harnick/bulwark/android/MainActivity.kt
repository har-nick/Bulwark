package uk.co.harnick.bulwark.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import uk.co.harnick.bulwark.common.di.ServiceLocator
import uk.co.harnick.bulwark.core.BulwarkApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ServiceLocator(applicationContext)
        setContent {
            BulwarkApp()
        }
    }
}
