package com.np.dagger2.practice.practical_7.di

import com.np.dagger2.practice.practical_7.external_lib.Rim
import com.np.dagger2.practice.practical_7.external_lib.Tire
import com.np.dagger2.practice.practical_7.utils.Wheels
import dagger.Module
import dagger.Provides

@Module
class WheelsModule {

    @Provides
    fun provideTire(): Tire {
        val tier = Tire()
        tier.setRadialTiers()
        return tier
    }

    @Provides
    fun provideRim() = Rim()

    @Provides
    fun provideWheels(rims: Rim, tires: Tire) = Wheels(rims, tires)
}