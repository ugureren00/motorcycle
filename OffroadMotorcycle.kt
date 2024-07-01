package com.example.motor

class OffroadMotorcycle(
    brand: String,
    model: String,
    year: Int,
    engineSize: Int,
    val groundClearance: Int
) : Motorcycle(brand, model, year, engineSize) {
    override fun printInfo() {
        println("Brand: $brand, Model: $model, Year: $year, Engine Size: $engineSize, Ground Clearance: $groundClearance")
    }
}