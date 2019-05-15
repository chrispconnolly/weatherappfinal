package com.codeathon.weather

data class WeatherModel(
    val summary: String,
    val icon: String,
    val temp: Double,
    val lat: Double,
    val long: Double
)