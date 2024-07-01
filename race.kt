package com.example.motor


import android.util.Log
import java.util.Random

fun race(motorcycle1: Motorcycle, motorcycle2: Motorcycle): Motorcycle {
    val random = Random()
    val winner = if (random.nextBoolean()) motorcycle1 else motorcycle2
    Log.d("MotorApp", "--- Race between ${motorcycle1.model} and ${motorcycle2.model}, Winner: ${winner.model}")
    return winner
}