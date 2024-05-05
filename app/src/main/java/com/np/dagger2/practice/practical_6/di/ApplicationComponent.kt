package com.np.dagger2.practice.practical_6.di

import com.np.dagger2.practice.practical_6.external_lib.Company
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
}