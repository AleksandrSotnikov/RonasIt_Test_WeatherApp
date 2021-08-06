package com.example.sotnikov.layout

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sotnikov.R

class NoInternet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_internet)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        Toast.makeText(
            this,
            "Отсутствует подключение к интернету, повторите попытку входа",
            Toast.LENGTH_LONG
        ).show()
    }

    fun onClickReload(view: View) {
        startActivity(Intent(this@NoInternet, SplashScreen::class.java))
        this@NoInternet.finish()
    }
}