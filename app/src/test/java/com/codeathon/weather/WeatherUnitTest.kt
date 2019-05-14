package com.codeathon.weather

import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.beust.klaxon.lookup
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class WeatherUnitTest {
    @Test
    fun `Reading weather data from a file`() {
        // read contents of json
        val fileContent: String = javaClass.getResource("/weather.json").readText()

        // create json object from file
        val stringBuilder: StringBuilder = StringBuilder(fileContent)
        val parser: Parser = Parser.default()
        val json: JsonObject = parser.parse(stringBuilder) as JsonObject

        val currently: JsonArray<String?> = json.lookup("currently")

        assert(53.93 == currently.double("temperature")[0])
        assert("partly-cloudy-day" == currently.string("icon")[0])
        assert("Mostly Cloudy" == currently.string("summary")[0])
    }

    @Test
    fun `Reading from Data Object`() {
        // read contents of json
        val fileContent: String = javaClass.getResource("/weather.json").readText()

        // create json object from file
        val stringBuilder: StringBuilder = StringBuilder(fileContent)
        val parser: Parser = Parser.default()
        val json: JsonObject = parser.parse(stringBuilder) as JsonObject

        val currently: JsonArray<String?> = json.lookup("currently")

        val temp: Double = currently.double("temperature")[0]!!
        val icon: String = currently.string("icon")[0]!!
        val summary: String = currently.string("summary")[0]!!

//        val currentWeatherModel = WeatherModel(temp, summary, icon)
//        assert(53.93 == currentWeatherModel.temperature)
//        assert("partly-cloudy-day" == currentWeatherModel.icon)
//        assert("Mostly Cloudy" == currentWeatherModel.summary)

    }
}



