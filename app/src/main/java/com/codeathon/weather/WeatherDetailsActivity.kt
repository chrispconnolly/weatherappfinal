package com.codeathon.weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.codeathon.weather.databinding.ActivityWeatherDetailsBinding



class WeatherDetailsActivity : AppCompatActivity() {

    private lateinit var viewModel: WeatherDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_details)

        viewModel = ViewModelProviders.of(this).get(WeatherDetailsViewModel::class.java)

        val binding : ActivityWeatherDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_weather_details)
        binding.viewModel = viewModel

    }
}

