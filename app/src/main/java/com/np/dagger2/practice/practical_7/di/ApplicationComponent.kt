package com.np.dagger2.practice.practical_7.di

import com.np.dagger2.practice.practical_7.external_lib.Company
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CompanyModule::class
    ]
)
interface ApplicationComponent {

    fun getCompany() = Company()

    fun getPetrolEnginCarComponent(): CarComponentWithPetrolEngine.Builder

    fun getDieselEnginCarComponent(dieselEngineModule: DieselEngineModule): CarComponentWithDieselEngine

    fun getHydrogenEnginCarComponent(hydrogenEngineModule: HydrogenEngineModule): CarComponentWithHydrogenEngine

    fun getElectricEnginCarComponent(): CarComponentWithElectricEngine.Factory
}