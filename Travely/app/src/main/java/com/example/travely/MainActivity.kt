package com.example.travely

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.travely.databinding.ActivityMainBinding

    //AppCompactActivity defines that the MainActivity go to behave as screen
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun calculate() {
            val distance = binding.editTravelDistance.text.toString().toInt()
            val price = binding.editGasCost.text.toString().toInt()
            val autonomy = binding.editVehicleAutonomy.text.toString().toInt()

            val result = (distance * price) / autonomy
            binding.textTotalCost.text = "R$ $result"
        }

        binding.buttonCalculate.setOnClickListener() {
            calculate()
        }



    }
}