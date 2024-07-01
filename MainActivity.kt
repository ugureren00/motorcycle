package com.example.motor

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.text_field)
        val button = findViewById<Button>(R.id.button)
        textView = findViewById<TextView>(R.id.result_text_view)

        button.setOnClickListener {
            val numMotorcycles = editText.text.toString().toInt()
            raceMotorcycles(numMotorcycles)
        }
    }

    private fun raceMotorcycles(numMotorcycles: Int) {
        val motorcycles = mutableListOf<Motorcycle>()

        for (i in 1..numMotorcycles) {
            motorcycles.add(createRandomMotorcycle())
        }

        while (motorcycles.size > 1) {
            val racePair = getRandomRacePair(motorcycles)
            println("Race between ${racePair.first.brand} ${racePair.first.model} and ${racePair.second.brand} ${racePair.second.model}")
            val winner = race(racePair.first, racePair.second)
            println("Winner: ${winner.brand} ${winner.model}")

            motorcycles.removeAll { it == racePair.second || it == racePair.first }
            motorcycles.add(winner)
        }

        println("Final Winner: ${motorcycles[0].brand} ${motorcycles[0].model}")
        textView.text = "Final Winner: ${motorcycles[0].brand} ${motorcycles[0].model}"
    }
    private fun createRandomMotorcycle(): Motorcycle {
        val randomBrand = getRandomBrand()
        val randomModel = getRandomModel()
        val randomYear = Random.nextInt(2022 - 2000) + 2000
        val randomEngineSize = Random.nextInt(2000) + 500

        val builder = MotorcycleBuilder()
        builder.setBrand(randomBrand)
            .setModel(randomModel)
            .setYear(randomYear)
            .setEngineSize(randomEngineSize)

        val randomType = Random.nextInt(4)

        return when (randomType) {
            0 -> builder.buildSportsMotorcycle()
            1 -> builder.buildCruiserMotorcycle()
            2 -> builder.buildTouringMotorcycle()
            else -> builder.buildOffroadMotorcycle()
        }
    }

    private fun getRandomBrand(): String {
        val brands = listOf("Honda", "Yamaha", "Suzuki", "Kawasaki", "Harley-Davidson")
        return brands[Random.nextInt(brands.size)]
    }

    private fun getRandomModel(): String {
        val models = listOf("CBR500R", "YZF-R6", "GSX-R750", "Ninja 650", "Softail")
        return models[Random.nextInt(models.size)]
    }

    private fun race(motorcycle1: Motorcycle, motorcycle2: Motorcycle): Motorcycle {

    
        return if (motorcycle1.engineSize > motorcycle2.engineSize) motorcycle1 else motorcycle2
    }

    private fun getRandomRacePair(motorcycles: MutableList<Motorcycle>): Pair<Motorcycle, Motorcycle> {
        val index1 = Random.nextInt(motorcycles.size)
        var index2 = Random.nextInt(motorcycles.size - 1)
        if (index2 >= index1) index2++
        return Pair(motorcycles[index1], motorcycles[index2])
    }
}
