package com.np.dagger2.practice.practical_7

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
import com.np.dagger2.practice.practical_7.di.DieselEngineModule
import com.np.dagger2.practice.practical_7.di.HydrogenEngineModule
import com.np.dagger2.practice.practical_7.utils.Car
import com.np.dagger2.ui.theme.Dagger2Theme
import javax.inject.Inject

class PracticalActivity : ComponentActivity() {

    @Inject
    lateinit var dieselCar: Car

    private lateinit var electricCar: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { View() }

        val petrolCar = (applicationContext as Dagger2Application)
            .applicationComponent
            .getPetrolEnginCarComponent()
            .hp(200)
            .capacity(4000)
            .build()
            .getCar()
        petrolCar.drive()

        (applicationContext as Dagger2Application)
            .applicationComponent
            .getDieselEnginCarComponent(
                DieselEngineModule(100, 2000)
            ).inject(this)

        val hydrogenCar = (applicationContext as Dagger2Application)
            .applicationComponent
            .getHydrogenEnginCarComponent(
                HydrogenEngineModule()
            )
            .getCar()
        hydrogenCar.drive()

        electricCar = (applicationContext as Dagger2Application)
            .applicationComponent
            .getElectricEnginCarComponent()
            .create(30000, 150)
            .getCar()
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
                        text = "Practical Activity 7"
                    )
                }
            }
        }
    }
}