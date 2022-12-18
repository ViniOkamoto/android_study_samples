package com.example.motivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

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