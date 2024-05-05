package com.np.dagger2.practice.practical_7.di

import com.np.dagger2.practice.practical_7.PracticalActivity
import com.np.dagger2.practice.practical_7.utils.Car
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [
        PetrolEngineModule::class,
        WheelsModule::class
    ]
)
interface CarComponentWithPetrolEngine {

    fun getCar(): Car

    fun inject(practicalActivity: PracticalActivity)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun hp(@HP hp: Int) : Builder

        @BindsInstance
        fun capacity(@Capacity capacity: Int) : Builder

        fun build(): CarComponentWithPetrolEngine
    }
}

@ActivityScope
@Subcomponent(
    modules = [
        DieselEngineModule::class,
        WheelsModule::class
    ]
)
interface CarComponentWithDieselEngine {

    fun getCar(): Car

    fun inject(practicalActivity: PracticalActivity)
}

@ActivityScope
@Subcomponent(
    modules = [
        HydrogenEngineModule::class,
        WheelsModule::class
    ]
)
interface CarComponentWithHydrogenEngine {

    fun getCar(): Car

    fun inject(practicalActivity: PracticalActivity)
}

@Subcomponent(
    modules = [
        ElectricEngineModule::class,
        WheelsModule::class
    ]
)
interface CarComponentWithElectricEngine {

    fun getCar(): Car

    fun inject(practicalActivity: PracticalActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance @HP hp: Int,
            @BindsInstance @Capacity capacity: Int
        ): CarComponentWithElectricEngine
    }
}