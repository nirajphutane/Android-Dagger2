package com.np.dagger2.practice.practical_6.di

import com.np.dagger2.practice.practical_6.external_lib.Company
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CompanyModule {

    companion object {
        @JvmStatic
        @Singleton
        @Provides
        fun provideCompany() = Company()
    }
}