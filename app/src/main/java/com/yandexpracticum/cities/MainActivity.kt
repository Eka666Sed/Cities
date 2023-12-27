package com.yandexpracticum.cities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yandexpracticum.cities.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // проверяем, если Activity пересоздаётся, то Fragment подгрузится автоматически
        if (savedInstanceState == null) {
            // в этот момент мы показываем Fragment со списком городов
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container_view, CitiesFragment())
                .commit()
        }

        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.replaceCountryFragment.setOnClickListener {
            // в этот момент мы заменяем Fragment со списком городов на Fragment со списком стран
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, CountriesFragment())
                .setReorderingAllowed(true)
                .commit()

        }
        binding.replaceBackStackCountryFragment.setOnClickListener {
            // в этот момент мы заменяем Fragment со списком городов на Fragment со списком стран, при этом сохраняя Fragment со списком городов в Back Stack
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, CountriesFragment())
                .addToBackStack("countries")
                .setReorderingAllowed(true)
                .commit()
        }
    }
}