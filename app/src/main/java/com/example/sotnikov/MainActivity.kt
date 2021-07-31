package com.example.sotnikov

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import com.example.sotnikov.api.weather.ApiWeather
import com.example.sotnikov.checker.LocationChecker
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.gson.Gson
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    lateinit var mAdView: AdView
    private var switch: SwitchCompat? = null
    private var apiWeather: ApiWeather? = null
    private var imageWeather: ImageView? = null
    private var temperature: TextView? = null
    private var city: TextView? = null
    private var wind: TextView? = null
    private var pressure: TextView? = null
    private var rain: TextView? = null
    private var humidity: TextView? = null
    private var type: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        apiWeather = Gson().fromJson(intent.getStringExtra("weather"), ApiWeather::class.java)
        init()
        fillActivity()
        LocationChecker.getPermission(this)
        if (intent.getBooleanExtra("isCheck", false)) apiWeather!!.name?.let { createDialog(it) }
    }

    private fun fillActivity() {
        Picasso.get()
            .load("http://openweathermap.org/img/wn/${apiWeather!!.getWeather()!![0].icon}@2x.png")
            .resize(128, 128).centerInside().into(imageWeather)
        city!!.text = apiWeather!!.name
        wind!!.text = apiWeather!!.getWind()!!.speed?.toInt().toString().plus(" м/c, ")
            .plus(apiWeather!!.getWind()!!.withDirection())
        humidity!!.text = apiWeather!!.getMain()!!.humidity.toString().plus("%")
        pressure!!.text = apiWeather!!.getMain()!!.withPressureMm().toString().plus(" мм рт. ст.")
        rain!!.text = apiWeather!!.getClouds()!!.all.toString().plus("%")
        temperature!!.text = apiWeather!!.getMain()!!.temp!!.toInt().toString().plus("°")
        type!!.text = apiWeather!!.getWeather()!![0].description
    }

    private fun init() {
        this.imageWeather = findViewById(R.id.ivWeather)
        this.city = findViewById(R.id.tvCity)
        this.wind = findViewById(R.id.tvWindResult)
        this.pressure = findViewById(R.id.tvPressureResult)
        this.rain = findViewById(R.id.tvChanceOfRainResult)
        this.humidity = findViewById(R.id.tvHumidityResult)
        this.type = findViewById(R.id.tvWeatherType)
        this.temperature = findViewById(R.id.tvTemperatureResult)
        this.switch = findViewById(R.id.switchDegree)
        this.switch!!.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                val temp = apiWeather!!.getMain()!!.temp!!.toInt() * 1.8 + 32
                temperature!!.text = temp.toString().plus("°")
            } else {
                temperature!!.text = apiWeather!!.getMain()!!.temp!!.toInt().toString().plus("°")
            }
        }
    }

    fun onClickMyLocation(view: View) {
        startActivity(Intent(this@MainActivity, SplashScreen::class.java))
        this@MainActivity.finish()
    }

    fun onClickCityChange(view: View) {
        startActivity(Intent(this@MainActivity, CitySearch::class.java))
    }

    private fun createDialog(city: String) {
        val builder = AlertDialog.Builder(this@MainActivity)
        builder
            .setTitle("Ваш город $city?")
            .setPositiveButton("Да") { _, _ -> }
            .setNegativeButton("Нет") { _, _ ->
                startActivity(Intent(this@MainActivity, CitySearch::class.java))
            }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}