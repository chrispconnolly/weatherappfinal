package com.codeathon.weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.codeathon.weather.databinding.LayoutDetailFinishedBinding



class WeatherDetailsActivity : AppCompatActivity() {

    private lateinit var viewModel: WeatherDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_detail_finished)

        viewModel = ViewModelProviders.of(this).get(WeatherDetailsViewModel::class.java)

        val binding : LayoutDetailFinishedBinding = DataBindingUtil.setContentView(this, R.layout.layout_detail_finished)
        binding.viewModel = viewModel

    }
}

