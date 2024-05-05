package com.np.dagger2.practice.practical_7.di

import com.np.dagger2.practice.practical_7.utils.DieselEngine
import com.np.dagger2.practice.practical_7.utils.ElectricEngine
import com.np.dagger2.practice.practical_7.utils.HydrogenEngine
import com.np.dagger2.practice.practical_7.utils.IEngine
import com.np.dagger2.practice.practical_7.utils.PetrolEngine
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
class HydrogenEngineModule {

    @Provides
    fun provideHydrogenEngine(): IEngine = HydrogenEngine()
}

@Module
abstract class ElectricEngineModule {

    @Binds
    abstract fun bindElectricEngine(electricEngine: ElectricEngine): IEngine
}