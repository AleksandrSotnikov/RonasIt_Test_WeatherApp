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
import com.example.sotnikov.library.TinyDB
import com.example.sotnikov.model.Sites

class NewSite : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_site)
    }

    fun onClickBack(view: View){
        startActivity(Intent(this@NewSite, NewsSites::class.java))
        this@NewSite.finish()
    }

    fun onClickCheck(view: View){
        val web = findViewById<WebView>(R.id.webView)
        val url = findViewById<EditText>(R.id.editTextURL)
        web.webChromeClient = WebChromeClient()
        web.webViewClient = MyWebClient()
        // включаем поддержку JavaScript
        web.loadUrl(url.text.toString())
    }

    fun onClickAdd(view: View){
        val tinyDB : TinyDB = TinyDB()
        val list = tinyDB.getListObject("Sites", Sites::class.java)
        val url = findViewById<EditText>(R.id.editTextURL)
        val name = findViewById<EditText>(R.id.editTextName)
        if(list.size == 0){
            val site = Sites()
            site.siteName = "Добавьте свои сайты в данный список"
            list.add(site)
        }
        list.add(Sites(name.text.toString(),url.text.toString()))
        tinyDB.putListObject("Sites",list)
        startActivity(Intent(this@NewSite, NewsSites::class.java))
        this@NewSite.finish()
    }

    override fun onBackPressed() {
        val web = findViewById<WebView>(R.id.webView)
        if (web.canGoBack()) {
            web.goBack()
        } else {
            super.onBackPressed()
        }
    }
}