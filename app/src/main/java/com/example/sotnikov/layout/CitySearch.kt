package com.example.sotnikov.layout

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.sotnikov.R
import com.example.sotnikov.api.city.Cityes
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.stream.Collectors

class CitySearch : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_search)
        val arrayAdapter: ArrayAdapter<String>
        val result =
            BufferedReader(InputStreamReader(resources.openRawResource(R.raw.city))).lines()
                .parallel().collect(Collectors.joining("\n"))
        val filterCity = findViewById<EditText>(R.id.etCity)
        val cityList = ArrayList<String>()
        Gson().fromJson(result, Cityes::class.java).cityes!!.forEach { x ->
            cityList.add(x.name.toString())
        }
        cityList.sort()
        val cityListView = findViewById<ListView>(R.id.listCity)
        arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, cityList
        )
        cityListView.adapter = arrayAdapter

        cityListView.setOnItemClickListener { _, view, _, _ ->
            val textView = view as TextView
            val splashScreenIntent = Intent(this@CitySearch, SplashScreen::class.java)
            splashScreenIntent.putExtra("city", textView.text.toString())
            startActivity(splashScreenIntent)
            this@CitySearch.finish()
        }
        filterCity.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                arrayAdapter.filter.filter(s)
            }
        })
    }
}