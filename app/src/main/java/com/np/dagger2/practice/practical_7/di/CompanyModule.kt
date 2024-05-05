package com.np.dagger2.practice.practical_7.di

import com.np.dagger2.practice.practical_7.external_lib.Company
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