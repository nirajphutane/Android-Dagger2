package com.np.dagger2.practice.practical_4.utils

import com.np.dagger2.practice.practical_4.external_lib.Rim
import com.np.dagger2.practice.practical_4.external_lib.Tire
import javax.inject.Inject

class Wheels @Inject constructor(rim: Rim, tier: Tire)