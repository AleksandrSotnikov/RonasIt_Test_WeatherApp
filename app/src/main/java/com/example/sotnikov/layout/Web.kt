package com.example.sotnikov.layout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.EditText
import com.example.sotnikov.R
import com.example.sotnikov.library.MyWebClient

class Web : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        val web = findViewById<WebView>(R.id.webView2)
        web.webChromeClient = WebChromeClient()
        web.webViewClient = MyWebClient()
        web.loadUrl(intent.getStringExtra("url").toString())
    }

    fun BackOnCLick(view : View){
        startActivity(Intent(this@Web, NewsSites::class.java))
        this@Web.finish()
    }
}