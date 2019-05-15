package com.codeathon.weather

import android.app.Application
import android.location.Geocoder
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import java.util.*

class WeatherDetailsViewModel(application: Application) : AndroidViewModel(application) {

    val summary = MutableLiveData<String>()
    val temp = MutableLiveData<String>()
    val icon = MutableLiveData<Int>()
    val location = MutableLiveData<String>()

    val windspeed = MutableLiveData<String>()
    val humidity = MutableLiveData<String>()
    val uvIndex = MutableLiveData<String>()
    val precipProbability = MutableLiveData<String>()


    init {
        val currentWeather: WeatherModel = Repo().loadCurrentWeather()
        summary.value = currentWeather.summary
        temp.value = currentWeather.temp.toString() + "º"
        icon.value = getImageSrc(currentWeather.icon)
        location.value = getLocation(currentWeather.lat, currentWeather.long)

        windspeed.value = (currentWeather.windspeed * 100).toString()
        humidity.value = (currentWeather.humidity *100).toString()
        uvIndex.value = getUvIndex(currentWeather.uvIndex)
        precipProbability.value = (currentWeather.precipProbability * 100).toString()
    }

    private fun getUvIndex(uvIndex: Int): String {
        return when(uvIndex) {
            1, 2 -> "Low"
            3, 4, 5 -> "Moderate"
            6, 7 -> "High"
            8, 9, 10 -> "Very High"
            else -> "Extreme"
        }
    }

    fun getImageSrc(icon: String): Int {
        return when (icon) {
            "clear-day" -> R.drawable.fill_6
            "clear-night" -> R.drawable.group_34
            "rain" -> R.drawable.group_27
            "snow" -> R.drawable.group_3
            "sleet" -> R.drawable.group_3
            "wind" -> R.drawable.group_10
            "fog" -> R.drawable.group_10
            "cloudy" -> R.drawable.cloudy
            "partly-cloudy-day" -> R.drawable.cloudy_sunny
            "partly-cloudy-night" -> R.drawable.night_raining_cloudy
            "hail" -> R.drawable.group_3
            "thunderstorm" -> R.drawable.group_6
            "tornado" -> R.drawable.group_6
            else -> R.drawable.cloudy_sunny
        }
    }

    fun getLocation(latitude: Double, longitude: Double): String {
        val geocoder = Geocoder(getApplication(), Locale.getDefault())
        val addresses = geocoder.getFromLocation(latitude, longitude, 1)
        val cityName = addresses[0].locality
        val stateName = addresses[0].adminArea
        val stateCode = StateUtils.getState(stateName)
        return "$cityName, $stateCode"
    }
}