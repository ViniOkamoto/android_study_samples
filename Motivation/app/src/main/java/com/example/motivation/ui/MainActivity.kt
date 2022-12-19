package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.example.motivation.core.services.LocalStorage
import com.example.motivation.R
import com.example.motivation.core.utils.AppConstants
import com.example.motivation.databinding.ActivityMainBinding
import com.example.motivation.`interface`.*
import com.example.motivation.data.Mock
import java.util.Locale

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var allFilter: FilterInterface
    private lateinit var happyFilter: FilterInterface
    private lateinit var sunnyFilter: FilterInterface
    private lateinit var currentFilter: FilterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        showUserName()

        initializeFilters()

        handleFilter(allFilter)

        initializeListeners()

    }
    private fun initializeListeners(){

        binding.newPhraseButton.setOnClickListener(this)
        binding.sunnyButton.setOnClickListener(this)
        binding.allButton.setOnClickListener(this)
        binding.happyButton.setOnClickListener(this)
    }

    private fun showUserName(){
        val name =  LocalStorage(this).getString(AppConstants.KEYS.USER_NAME)
        val greeting = "${getString(R.string.hello)} $name"
        binding.textGreetings.text = greeting
    }

    private fun initializeFilters() {
        allFilter = AllFilter(R.id.all_button)
        happyFilter = HappyFilter(R.id.happy_button)
        sunnyFilter = SunnyFilter(R.id.sunny_button)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.new_phrase_button -> {
                handleNewPhrase()
            }
            R.id.sunny_button ->{
                    handleFilter(sunnyFilter)
            }
            R.id.all_button ->{
                handleFilter(allFilter)
            }
            R.id.happy_button ->{
                handleFilter(happyFilter)
            }
        }
    }

    private fun handleNewPhrase() {
        val language = Locale.getDefault().language
        Mock().getPhrase(currentFilter.categoryId,language ).let {
            binding.textView.text = it
        }
    }

    private fun handleFilter(filter: FilterInterface) {
        resetFilters()

        val filterButton = findViewById<ImageView>(filter.filterId)
        filterButton.setColorFilter(ContextCompat.getColor(this, R.color.white))
        currentFilter = filter
        handleNewPhrase()
    }

    private fun resetFilters(){
        binding.sunnyButton.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.allButton.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.happyButton.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
    }
}