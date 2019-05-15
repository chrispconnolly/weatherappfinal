package com.codeathon.weather

import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.beust.klaxon.lookup

class Repo {

    fun loadCurrentWeather(): WeatherModel {

        // create json object from file
        val stringBuilder: StringBuilder = StringBuilder(currentWeatherJson)
        val parser: Parser = Parser.default()
        val json: JsonObject = parser.parse(stringBuilder) as JsonObject

        val currently: JsonArray<String> = json.lookup("currently")

        val temp: Double = currently.double("temperature")[0] as Double
        val icon: String = currently.string("icon")[0] as String
        val summary: String = currently.string("summary")[0] as String

        val lat = json.lookup<Double>("latitude")[0]
        val long = json.lookup<Double>("longitude")[0]

        val windspeed: Double =  currently.double("windSpeed")[0] as Double
        val humidity: Double =  currently.double("humidity")[0] as Double
        val uvIndex =  currently.int("uvIndex")[0] as Int

        var precipProbability: Double

        try {
            precipProbability = currently.double("precipProbability")[0] as Double
        } catch (e: ClassCastException) {
            precipProbability = (currently.int("precipProbability")[0] as Int).toDouble()
        }

        return WeatherModel(summary, icon, temp, lat, long, windspeed, humidity, uvIndex, precipProbability)

    }

private val currentWeatherJson = "{" +
        "  \"latitude\": 38.9339," +
        "  \"longitude\": -77.1773," +
        "  \"timezone\": \"America/New_York\"," +
        "  \"currently\": {" +
        "    \"time\": 1557682817," +
        "    \"summary\": \"Light Rain\"," +
        "    \"icon\": \"rain\"," +
        "    \"nearestStormDistance\": 0," +
        "    \"precipIntensity\": 0.0147," +
        "    \"precipIntensityError\": 0.004," +
        "    \"precipProbability\": 1," +
        "    \"precipType\": \"rain\"," +
        "    \"temperature\": 53.89," +
        "    \"apparentTemperature\": 53.89," +
        "    \"dewPoint\": 53.57," +
        "    \"humidity\": 0.99," +
        "    \"pressure\": 1007.34," +
        "    \"windSpeed\": 5.78," +
        "    \"windGust\": 5.78," +
        "    \"windBearing\": 21," +
        "    \"cloudCover\": 1," +
        "    \"uvIndex\": 5," +
        "    \"visibility\": 3.89," +
        "    \"ozone\": 292.13" +
        "  }," +
        "  \"flags\": {" +
        "    \"sources\": [" +
        "      \"nearest-precip\"," +
        "      \"nwspa\"," +
        "      \"cmc\"," +
        "      \"gfs\"," +
        "      \"hrrr\"," +
        "      \"icon\"," +
        "      \"isd\"," +
        "      \"madis\"," +
        "      \"nam\"," +
        "      \"sref\"," +
        "      \"darksky\"" +
        "    ]," +
        "    \"nearest-station\": 2.494," +
        "    \"units\": \"us\"" +
        "  }," +
        "  \"offset\": -4" +
        "}"}