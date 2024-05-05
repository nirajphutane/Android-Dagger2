package com.np.dagger2.practice.practical_3.di

import com.np.dagger2.practice.practical_3.utils.DieselEngine
import com.np.dagger2.practice.practical_3.utils.IEngine
import com.np.dagger2.practice.practical_3.utils.PetrolEngine
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class PetrolEngineModule {

    @Binds
    abstract fun bindPetrolEngine(petrolEngine: PetrolEngine): IEngine
}

@Module
class DieselEngineModule {

    @Provides
    fun provideDieselEngine(): IEngine = DieselEngine()
}