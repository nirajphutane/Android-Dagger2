package com.np.dagger2.practice.practical_5.di

import com.np.dagger2.practice.practical_5.PracticalActivity
import com.np.dagger2.practice.practical_5.utils.Car
import dagger.Component
import dagger.BindsInstance

@Component(
    modules = [
        PetrolEngineModule::class,
        WheelsModule::class
    ]
)
interface CarComponentWithPetrolEngine {

    fun getCar(): Car

    fun inject(practicalActivity: PracticalActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun hp(@HP hp: Int) : Builder

        @BindsInstance
        fun capacity(@Capacity capacity: Int) : Builder

        fun build(): CarComponentWithPetrolEngine
    }
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

@Component(
    modules = [
        HydrogenEngineModule::class,
        WheelsModule::class
    ]
)
interface CarComponentWithHydrogenEngine {

    fun getCar(): Car

    fun inject(practicalActivity: PracticalActivity)
}

@Component(
    modules = [
        ElectricEngineModule::class,
        WheelsModule::class
    ]
)
interface CarComponentWithElectricEngine {

    fun getCar(): Car

    fun inject(practicalActivity: PracticalActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @HP hp: Int,
            @BindsInstance @Capacity capacity: Int
        ): CarComponentWithElectricEngine
    }
}