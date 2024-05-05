package com.np.dagger2.practice.practical_4.di

import com.np.dagger2.practice.practical_4.utils.DieselEngine
import com.np.dagger2.practice.practical_4.utils.IEngine
import com.np.dagger2.practice.practical_4.utils.PetrolEngine
import com.np.dagger2.practice.practical_4.utils.ElectricEngine
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class PetrolEngineModule {

    @Binds
    abstract fun bindPetrolEngine(petrolEngine: PetrolEngine): IEngine
}

@Module
class DieselEngineModule(private val hp: Int, private val capacity: Int) {

    @Provides
    fun provideDieselEngine(): IEngine = DieselEngine(hp, capacity)
}

@Module
abstract class ElectricEngineModule {

    @Binds
    abstract fun bindElectricEngine(electricEngine: ElectricEngine): IEngine
}