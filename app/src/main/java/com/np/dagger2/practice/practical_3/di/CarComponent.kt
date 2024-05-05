package com.np.dagger2.practice.practical_3.di

import com.np.dagger2.practice.practical_3.PracticalActivity
import com.np.dagger2.practice.practical_3.utils.Car
import dagger.Component

@Component(
    modules = [
        PetrolEngineModule::class,
        WheelsModule::class
    ]
)
interface CarComponentWithPetrolEngine {

    fun getCar(): Car

    fun inject(practicalActivity: PracticalActivity)
}

@Component(
    modules = [
        DieselEngineModule::class,
        WheelsModule::class
    ]
)
interface CarComponentWithDieselEngine {

    fun getCar(): Car

    fun inject(practicalActivity: PracticalActivity)
}