package com.example.travely

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.travely.databinding.ActivityMainBinding

//AppCompactActivity defines that the MainActivity go to behave as screen
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonCalculate.setOnClickListener {
            calculate()
        }


    }

    private fun validate(): Boolean {
        return (binding.editGasCost.text.toString() != "" && binding.editTravelDistance.text.toString() != "" && binding.editVehicleAutonomy.text.toString() != "" && binding.editVehicleAutonomy.text.toString().toFloat() != 0f)
    }

    private fun calculate() {
        if(validate()){
            val distance = binding.editTravelDistance.text.toString().toInt()
            val price = binding.editGasCost.text.toString().toInt()
            val autonomy = binding.editVehicleAutonomy.text.toString().toInt()

            val result = (distance * price) / autonomy
            binding.textTotalCost.text = "R$ ${"%.2f".format(result)}"
            return;
        }
        Toast.makeText(this, R.string.validate_error_all_fields, Toast.LENGTH_SHORT).show()
    }
}