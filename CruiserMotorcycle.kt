package com.example.motor

class CruiserMotorcycle(
    brand: String,
    model: String,
    year: Int,
    engineSize: Int,
    val seatHeight: Int
) : Motorcycle(brand, model, year, engineSize) {
    override fun printInfo() {
        println("Brand: $brand, Model: $model, Year: $year, Engine Size: $engineSize, Seat Height: $seatHeight")
    }
}