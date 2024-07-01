package com.example.motor

class TouringMotorcycle(
    brand: String,
    model: String,
    year: Int,
    engineSize: Int,
    val luggageCapacity: Int
) : Motorcycle(brand, model, year, engineSize) {
    override fun printInfo() {
        println("Brand: $brand, Model: $model, Year: $year, Engine Size: $engineSize, Luggage Capacity: $luggageCapacity")
    }
}