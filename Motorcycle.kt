package com.example.motor

abstract class Motorcycle(
    val brand: String,
    val model: String,
    val year: Int,
    val engineSize: Int
) {
    abstract fun printInfo()
}