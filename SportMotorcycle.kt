package com.example.motor

class SportsMotorcycle(
    brand: String,
    model: String,
    year: Int,
    engineSize: Int,
    val topSpeed: Int
) : Motorcycle(brand, model, year, engineSize) {
    override fun printInfo() {
        println("Brand: $brand, Model: $model, Year: $year, Engine Size: $engineSize, Top Speed: $topSpeed")
    }
}