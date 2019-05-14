package com.codeathon.weather



//    fun getImageSrc(icon:String):Int{
//        return when(icon){
//            "clear-day" -> R.drawable.fill_6
//            "clear-night" -> R.drawable.group_34
//            "rain" -> R.drawable.group_27
//            "snow" -> R.drawable.group_3
//            "sleet" -> R.drawable.group_3
//            "wind" -> R.drawable.group_10
//            "fog" -> R.drawable.group_10
//            "cloudy" -> R.drawable.cloudy
//            "partly-cloudy-day" -> R.drawable.cloudy_sunny
//            "partly-cloudy-night" -> R.drawable.night_raining_cloudy
//            "hail" -> R.drawable.group_3
//            "thunderstorm" -> R.drawable.group_6
//            "tornado" ->  R.drawable.group_6
//            else -> R.drawable.cloudy_sunny
//        }
//    }

//fun getLocation(latitude: Double, longitude: Double): String {
//    val geocoder = Geocoder(getApplication(), Locale.getDefault())
//    val addresses = geocoder.getFromLocation(latitude, longitude, 1)
//    val cityName = addresses[0].locality
//    val stateName = addresses[0].adminArea
//    val stateCode = StateUtils.getState(stateName)
//    return "$cityName, $stateCode"
//}
