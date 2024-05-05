package com.np.dagger2.practice.practical_4.di

import com.np.dagger2.practice.practical_4.external_lib.Rim
import com.np.dagger2.practice.practical_4.external_lib.Tire
import com.np.dagger2.practice.practical_4.utils.Wheels
import dagger.Module
import dagger.Provides

@Module
class WheelsModule {

//    @Provides
//    fun provideTire(): Tire {
//        val tier = Tire()
//        tier.setRadialTiers()
//        return tier
//    }
//
//    @Provides
//    fun provideRim() = Rim()
//
//    @Provides
//    fun provideWheels(rims: Rim, tires: Tire) = Wheels(rims, tires)

// Static Module

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideTire(): Tire {
            val tier = Tire()
            tier.setRadialTiers()
            return tier
        }

        @JvmStatic
        @Provides
        fun provideRim() = Rim()

        @JvmStatic
        @Provides
        fun provideWheels(rims: Rim, tires: Tire) = Wheels(rims, tires)
    }
}