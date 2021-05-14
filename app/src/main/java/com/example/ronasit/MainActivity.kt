package com.example.ronasit

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.ronasit.api.ApiWeather
import com.google.gson.Gson
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fillActivity();


    }
    private fun fillActivity(){
        val apiWeather = Gson().fromJson(intent.getStringExtra("weather"), ApiWeather::class.java)
        var image : ImageView = findViewById(R.id.ivWeather);
        Picasso.get().load("http://openweathermap.org/img/wn/${apiWeather.weather.get(0).icon}@2x.png") .resize(128, 128).centerCrop().into(image)

    }
}