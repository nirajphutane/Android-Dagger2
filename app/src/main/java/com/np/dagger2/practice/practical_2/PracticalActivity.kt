package com.np.dagger2.practice.practical_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.np.dagger2.practice.practical_2.di.DaggerCarComponent
import com.np.dagger2.practice.practical_2.utils.Car
import com.np.dagger2.ui.theme.Dagger2Theme
import javax.inject.Inject

class PracticalActivity : ComponentActivity() {

    // Field Injection
    @Inject
    lateinit var carByFI: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { View() }

        val carComponent = DaggerCarComponent.create()

        // Constructor Injection
        val carByCI = carComponent.getCar()
        carByCI.drive()

        carComponent.inject(this)
        carByFI.drive()
    }

    @Composable
    private fun View() {
        Dagger2Theme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = "Practical Activity 2"
                    )
                }
            }
        }
    }
}