package com.np.dagger2.practice.practical_6.di

import com.np.dagger2.practice.practical_6.PracticalActivity
import com.np.dagger2.practice.practical_6.utils.Car
import dagger.Component
import dagger.BindsInstance

@ActivityScope
@Component(
    dependencies = [
        ApplicationComponent::class
    ],
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

        fun getApplicationComponent(applicationComponent: ApplicationComponent): Builder

        @BindsInstance
        fun hp(@HP hp: Int) : Builder

        @BindsInstance
        fun capacity(@Capacity capacity: Int) : Builder

        fun build(): CarComponentWithPetrolEngine
    }
}

@ActivityScope
@Component(
    dependencies = [
        ApplicationComponent::class
    ],
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
@Component(
    dependencies = [
        ApplicationComponent::class
    ],
    modules = [
        HydrogenEngineModule::class,
        WheelsModule::class
    ]
)
interface CarComponentWithHydrogenEngine {

    fun getCar(): Car

    fun inject(practicalActivity: PracticalActivity)
}

@ActivityScope
@Component(
    dependencies = [
        ApplicationComponent::class
    ],
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
            applicationComponent: ApplicationComponent,
            @BindsInstance @HP hp: Int,
            @BindsInstance @Capacity capacity: Int
        ): CarComponentWithElectricEngine
    }
}