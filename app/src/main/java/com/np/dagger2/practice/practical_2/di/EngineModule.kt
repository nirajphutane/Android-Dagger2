package com.np.dagger2.practice.practical_2.di

import com.np.dagger2.practice.practical_2.utils.DieselEngine
import com.np.dagger2.practice.practical_2.utils.IEngine
import com.np.dagger2.practice.practical_2.utils.PetrolEngine
import dagger.Binds
import dagger.Module
import javax.inject.Named

@Module
abstract class EngineModule {

    @Named("PetrolEngine")
    @Binds
    abstract fun bindPetrolEngine(petrolEngine: PetrolEngine): IEngine

    @Named("DieselEngine")
    @Binds
    abstract fun bindDieselEngine(dieselEngine: DieselEngine): IEngine
}