package com.np.dagger2.practice.practical_1.di

import com.np.dagger2.practice.practical_1.PracticalActivity
import com.np.dagger2.practice.practical_1.utils.Car
import dagger.Component

@Component
interface CarComponent {

    fun getCar(): Car

    fun inject(practicalActivity: PracticalActivity)
}