package com.codeathon.weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_weather_details.*

class WeatherDetailsActivity : AppCompatActivity() {

    private lateinit var viewModel: WeatherDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_details)

        viewModel = ViewModelProviders.of(this).get(WeatherDetailsViewModel::class.java)

        summary_textview.text = viewModel.summary.value
        temp_textView.text = viewModel.temp.value

        viewModel.icon.value?.let {
            icon.setImageResource(it)
        }



    }
}
