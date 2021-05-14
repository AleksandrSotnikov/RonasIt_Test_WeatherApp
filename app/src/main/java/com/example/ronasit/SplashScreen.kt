package com.example.ronasit

import android.annotation.SuppressLint
import android.content.Intent
import android.location.Location
import android.location.LocationManager
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ronasit.checker.InternetChecker
import com.example.ronasit.checker.LocationChecker
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL


private var locationManager : LocationManager? = null
private var location : Location? = null

class SplashScreen : AppCompatActivity() {
    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        LocationChecker.getPermission(this)
        if(InternetChecker.hasConnection(this)){
            locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
            location = when {
                LocationChecker.checkEnabledNetwork(locationManager) -> {
                    locationManager?.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                }
                LocationChecker.checkEnabledGPS(locationManager) -> {
                    locationManager?.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                }
                else -> {
                    Toast.makeText(this,"Отсутвует соедиенения со службами определения местоположения",Toast.LENGTH_LONG).show()
                    return
                }
            }
            if(location == null) return
            WeatherAsync().execute()
        }else{
            Toast.makeText(this, "Отсутствиет соединение с интернетом, перезапустите приложение", Toast.LENGTH_SHORT).show()
        }
    }

    inner class WeatherAsync : AsyncTask<Void, Void, String>() {
        override fun doInBackground(vararg params: Void): String? {
            val urlWeatherString = "http://api.openweathermap.org/data/2.5/weather?"
                .plus("lat=")
                .plus(location!!.latitude)
                .plus("&lon=")
                .plus(location!!.longitude)
                .plus("&appid=")
                .plus(baseContext.getString(R.string.weather_api))
            val inputHttpWeather: InputStream = URL(urlWeatherString)
                .openConnection()
                .inputStream as InputStream
            val reader = BufferedReader(InputStreamReader(inputHttpWeather))
            return reader.readLine()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            val mainIntent = Intent(this@SplashScreen, MainActivity::class.java)
            mainIntent.putExtra("weather", result)
            this@SplashScreen.startActivity(mainIntent)
            this@SplashScreen.finish()
        }
    }
}