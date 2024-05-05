package com.np.dagger2.practice.practical_2.di

import com.np.dagger2.practice.practical_2.PracticalActivity
import com.np.dagger2.practice.practical_2.utils.Car
import dagger.Component

@Component(
    modules = [
        EngineModule::class
    ]
)
interface CarComponent {

    fun getCar(): Car

    fun inject(practicalActivity: PracticalActivity)
}