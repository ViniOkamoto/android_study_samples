package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivation.core.services.LocalStorage
import com.example.motivation.R
import com.example.motivation.core.utils.StorageConstants
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        var name =  LocalStorage(this).getString(StorageConstants.KEY.USER_NAME)
        binding.textGreetings.text = "Hello, $name"
        binding.newPhraseButton.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        if(view?.id == R.id.newPhraseButton) {
            var s = ""
//            val phrase = binding.phraseText.text.toString()
//            val author = binding.authorText.text.toString()
//            val intent = Intent(this, PhraseActivity::class.java)
//            intent.putExtra("phrase", phrase)
//            intent.putExtra("author", author)
//            startActivity(intent)
        }
    }
}