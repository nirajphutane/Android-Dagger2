package com.np.dagger2.practice.practical_1

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
import com.np.dagger2.practice.practical_1.di.DaggerCarComponent
import com.np.dagger2.practice.practical_1.utils.Car
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
                        text = "Practical Activity 1"
                    )
                }
            }
        }
    }
}

/*
- In Dagger 2, executes as following order:
    1. Constructor Injection
    2. Field Injection
    3. Method Injection
- Constructor Injection is the most preferred type of injection because it ensures that the object is properly initialized.
- Field Injection can be used to inject objects that are not required for the object to be created.
- Method Injection is when Dagger calls an @Inject -annotated method on a class used to inject a class's method, which is called automatically after class creation.
*/