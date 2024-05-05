package com.np.dagger2.practice.practical_4

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
import com.np.dagger2.practice.practical_4.di.DaggerCarComponentWithDieselEngine
import com.np.dagger2.practice.practical_4.di.DaggerCarComponentWithPetrolEngine
import com.np.dagger2.practice.practical_4.di.DieselEngineModule
import com.np.dagger2.practice.practical_4.utils.Car
import com.np.dagger2.practice.practical_4.di.DaggerCarComponentWithElectricEngine
import com.np.dagger2.ui.theme.Dagger2Theme
import javax.inject.Inject

class PracticalActivity : ComponentActivity() {

    @Inject
    lateinit var dieselCar: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { View() }

        val carComponentWithPetrolEngine = DaggerCarComponentWithPetrolEngine
            .builder()
            .hp(20000)
            .capacity(100)
            .build()
        val petrolCar = carComponentWithPetrolEngine.getCar()
        petrolCar.drive()

        val carComponentWithDieselEngine = DaggerCarComponentWithDieselEngine
            .builder()
            .dieselEngineModule(
                DieselEngineModule(40000, 200)
            )
            .build()
        carComponentWithDieselEngine.inject(this)
        dieselCar.drive()

        val carComponentWithElectricEngine = DaggerCarComponentWithElectricEngine
            .factory()
            .create(30000, 150)
        val electricCar = carComponentWithElectricEngine.getCar()
        electricCar.drive()
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
                        text = "Practical Activity 4"
                    )
                }
            }
        }
    }
}