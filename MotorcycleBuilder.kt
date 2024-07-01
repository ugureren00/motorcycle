package com.example.motor

import kotlin.random.Random

class MotorcycleBuilder {
    private var brand: String = ""
    private var model: String = ""
    private var year: Int = 0
    private var engineSize: Int = 0

    fun setBrand(brand: String) = apply { this.brand = brand }
    fun setModel(model: String) = apply { this.model = model }
    fun setYear(year: Int) = apply { this.year = year }
    fun setEngineSize(engineSize: Int) = apply { this.engineSize = engineSize }

    fun buildSportsMotorcycle(): SportsMotorcycle {
        return SportsMotorcycle(brand, model, year, engineSize, Random.nextInt(250) + 150)
    }

    fun buildCruiserMotorcycle(): CruiserMotorcycle {
        return CruiserMotorcycle(brand, model, year, engineSize, Random.nextInt(30) + 25)
    }

    fun buildTouringMotorcycle(): TouringMotorcycle {
        return TouringMotorcycle(brand, model, year, engineSize, Random.nextInt(100) + 50)
    }

    fun buildOffroadMotorcycle(): OffroadMotorcycle {
        return OffroadMotorcycle(brand, model, year, engineSize, Random.nextInt(10) + 7)
    }
}