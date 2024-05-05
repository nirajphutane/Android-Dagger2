package com.np.dagger2.practice.practical_4.utils

import com.np.dagger2.core.appLog
import com.np.dagger2.practice.practical_4.di.Capacity
import com.np.dagger2.practice.practical_4.di.HP
import javax.inject.Inject

interface IEngine {

    fun start()
}

// With @Inject
class PetrolEngine @Inject constructor(@HP private val hp: Int, @Capacity private val capacity: Int) : IEngine  {

    override fun start() {
        appLog("PetrolEngine(${this.hashCode()}) of $hp HP with $capacity capacity is Started.")
    }
}

// Like 3th party library (without @Inject)
class DieselEngine(private val hp: Int, private val capacity: Int) : IEngine  {

    override fun start() {
        appLog("DieselEngine(${this.hashCode()}) of $hp HP with $capacity capacity is Started.")
    }
}

// With @Inject
class ElectricEngine @Inject constructor(@HP private val hp: Int, @Capacity private val capacity: Int) : IEngine {

    override fun start() {
        appLog("ElectricEngine(${this.hashCode()}) of $hp HP with $capacity capacity is Started.")
    }
}