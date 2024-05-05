package com.np.dagger2.practice.practical_3

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
import com.np.dagger2.practice.practical_3.di.DaggerCarComponentWithDieselEngine
import com.np.dagger2.practice.practical_3.di.DaggerCarComponentWithPetrolEngine
import com.np.dagger2.practice.practical_3.utils.Car
import com.np.dagger2.ui.theme.Dagger2Theme
import javax.inject.Inject

class PracticalActivity : ComponentActivity() {

    // Field Injection
    @Inject
    lateinit var dieselCar: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { View() }

        val carComponentWithPetrolEngine = DaggerCarComponentWithPetrolEngine.create()
        // Constructor Injection
        val petrolCar = carComponentWithPetrolEngine.getCar()
        petrolCar.drive()

        val carComponentWithDieselEngine = DaggerCarComponentWithDieselEngine.create()
        carComponentWithDieselEngine.inject(this)
        dieselCar.drive()
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
                        text = "Practical Activity 3"
                    )
                }
            }
        }
    }
}