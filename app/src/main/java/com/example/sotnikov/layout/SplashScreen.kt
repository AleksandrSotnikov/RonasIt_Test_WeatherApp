@file:Suppress("DEPRECATION")

package com.example.sotnikov.layout


import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.location.Location
import android.location.LocationManager
import android.os.AsyncTask
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.sotnikov.R
import com.example.sotnikov.checker.InternetChecker
import com.example.sotnikov.checker.LocationChecker
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL


private var locationManager: LocationManager? = null
private var location: Location? = null
private var city: String? = null
private var geolocationEnabled = false

class SplashScreen : AppCompatActivity() {

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        LocationChecker.getPermission(this)
        city = intent.getStringExtra("city")
        if (InternetChecker.hasConnection(this)) {
            if (city == null) {
                locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
                location = when {
                    LocationChecker.checkEnabledNetwork(locationManager) -> {
                        locationManager?.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                    }
                    LocationChecker.checkEnabledGPS(locationManager) -> {
                        locationManager?.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                    }
                    else -> {
                        Toast.makeText(
                            this,
                            "Отсутвует соедиенения со службами определения местоположения",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(Intent(this@SplashScreen, CitySearch::class.java))
                        this@SplashScreen.finish()
                        return
                    }
                }
            }
            if (location == null && city == null) {
                startActivity(Intent(this@SplashScreen, SplashScreen::class.java))
                this@SplashScreen.finish()
            }
            WeatherAsync().execute()
        } else {
            Toast.makeText(
                this,
                "Отсутствиет соединение с интернетом, перезапустите приложение",
                Toast.LENGTH_SHORT
            ).show()
            startActivity(Intent(this@SplashScreen, NoInternet::class.java))
            this@SplashScreen.finish()
        }
    }

    @Suppress("DEPRECATION")
    @SuppressLint("StaticFieldLeak")
    inner class WeatherAsync : AsyncTask<Void, Void, String>() {
        override fun doInBackground(vararg params: Void): String? {
            var urlWeatherString: String = "http://api.openweathermap.org/data/2.5/weather?"
                .plus("lang=ru")
                .plus("&units=metric")
                .plus("&appid=")
                .plus(baseContext.getString(R.string.weather_api))
            urlWeatherString = if (city == null) {
                urlWeatherString
                    .plus("&lat=")
                    .plus(location!!.latitude)
                    .plus("&lon=")
                    .plus(location!!.longitude)
            } else {
                urlWeatherString
                    .plus("&q=")
                    .plus(city)
            }
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
            if (city == null) mainIntent.putExtra("isCheck", true)
            this@SplashScreen.startActivity(mainIntent)
            this@SplashScreen.finish()
        }
    }

    private fun checkLocationServiceEnabled(): Boolean {
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        try {
            geolocationEnabled = locationManager!!.isProviderEnabled(LocationManager.GPS_PROVIDER)
        } catch (ex: Exception) {
        }
        return geolocationEnabled
    }

    private fun buildAlertMessageNoLocationService(network_enabled: Boolean): Boolean {
        val msg = if (!network_enabled) resources.getString(R.string.msg_switch_network) else null
        var click = false
        if (msg != null) {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder.setCancelable(false)
                .setMessage(msg)
                .setPositiveButton("Включить",
                    DialogInterface.OnClickListener { dialog, id ->
                        startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
                        click = true
                    })
                .setNegativeButton("Отмена",
                    DialogInterface.OnClickListener { dialog, id ->
                        click = false
                    })
            val alert: AlertDialog = builder.create()
            alert.show()
            return click
        }
        return false
    }
}