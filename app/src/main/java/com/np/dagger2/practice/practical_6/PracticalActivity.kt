package com.np.dagger2.practice.practical_6

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
import com.np.dagger2.practice.practical_6.di.DaggerCarComponentWithDieselEngine
import com.np.dagger2.practice.practical_6.di.DaggerCarComponentWithHydrogenEngine
import com.np.dagger2.practice.practical_6.di.DaggerCarComponentWithPetrolEngine
import com.np.dagger2.practice.practical_6.di.DaggerCarComponentWithElectricEngine
import com.np.dagger2.practice.practical_6.di.DieselEngineModule
import com.np.dagger2.practice.practical_6.utils.Car
import com.np.dagger2.ui.theme.Dagger2Theme
import javax.inject.Inject

class PracticalActivity : ComponentActivity() {

    @Inject
    lateinit var dieselCar: Car

    private lateinit var hydrogenCar: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { View() }

        val petrolCar = DaggerCarComponentWithPetrolEngine
            .builder()
            .getApplicationComponent((applicationContext as Dagger2Application).applicationComponent)
            .hp(100)
            .capacity(2000)
            .build()
            .getCar()
        petrolCar.drive()

        DaggerCarComponentWithDieselEngine
            .builder()
            .applicationComponent((applicationContext as Dagger2Application).applicationComponent)
            .dieselEngineModule(DieselEngineModule(100, 2000))
            .build()
            .inject(this)

        hydrogenCar = DaggerCarComponentWithHydrogenEngine
            .builder()
            .applicationComponent((applicationContext as Dagger2Application).applicationComponent)
            .build()
            .getCar()
        hydrogenCar.drive()

        val electricCar = DaggerCarComponentWithElectricEngine
            .factory()
            .create(
                (applicationContext as Dagger2Application).applicationComponent,
                30000,
                150
            )
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
                        text = "Practical Activity 6"
                    )
                }
            }
        }
    }
}