package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.core.services.LocalStorage
import com.example.motivation.R
import com.example.motivation.core.utils.AppConstants
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.buttonSave.setOnClickListener(this)

        verifyIfUserExists()
    }

    private fun verifyIfUserExists() {
        val name = LocalStorage(this).getString(AppConstants.KEYS.USER_NAME)
        if(name != "") {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.button_save) {
            handleSave()
        }
    }

    private fun handleSave() {
        val name: String = binding.editName.text.toString()
        if (name != "") {
            val storage = LocalStorage(this)
            storage.storeString(AppConstants.KEYS.USER_NAME, name)

            startActivity(
                Intent(this, MainActivity::class.java)
            )
            finish()
        } else {
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_SHORT).show()
        }
    }
}