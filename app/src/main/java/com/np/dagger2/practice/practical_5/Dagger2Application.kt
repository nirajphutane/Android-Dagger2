package com.np.dagger2.practice.practical_5

import android.app.Application
import com.np.dagger2.practice.practical_5.di.CarComponentWithDieselEngine
import com.np.dagger2.practice.practical_5.di.CarComponentWithElectricEngine
import com.np.dagger2.practice.practical_5.di.CarComponentWithHydrogenEngine
import com.np.dagger2.practice.practical_5.di.CarComponentWithPetrolEngine
import com.np.dagger2.practice.practical_5.di.DaggerCarComponentWithDieselEngine
import com.np.dagger2.practice.practical_5.di.DaggerCarComponentWithElectricEngine
import com.np.dagger2.practice.practical_5.di.DaggerCarComponentWithHydrogenEngine
import com.np.dagger2.practice.practical_5.di.DaggerCarComponentWithPetrolEngine
import com.np.dagger2.practice.practical_5.di.DieselEngineModule

class Dagger2Application: Application() {

    lateinit var carComponentWithPetrolEngine: CarComponentWithPetrolEngine
    lateinit var carComponentWithDieselEngine: CarComponentWithDieselEngine
    lateinit var carComponentWithHydrogenEngine: CarComponentWithHydrogenEngine
    lateinit var carComponentWithElectricEngine: CarComponentWithElectricEngine

    override fun onCreate() {
        super.onCreate()

        carComponentWithPetrolEngine = DaggerCarComponentWithPetrolEngine
            .builder()
            .hp(20000)
            .capacity(100)
            .build()

        carComponentWithDieselEngine = DaggerCarComponentWithDieselEngine
            .builder()
            .dieselEngineModule(
                DieselEngineModule(40000, 200)
            )
            .build()

        carComponentWithHydrogenEngine = DaggerCarComponentWithHydrogenEngine.create()

        carComponentWithElectricEngine = DaggerCarComponentWithElectricEngine
            .factory()
            .create(30000, 150)
    }
}