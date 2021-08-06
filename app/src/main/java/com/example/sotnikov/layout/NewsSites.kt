package com.example.sotnikov.layout

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.sotnikov.NewsSiteFragment
import com.example.sotnikov.R
import com.example.sotnikov.library.App
import com.example.sotnikov.library.TinyDB
import com.example.sotnikov.model.Sites
import com.example.sotnikov.placeholder.PlaceholderContent

class NewsSites : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_sites)
        App.activity = this@NewsSites
    }

    fun addNewSite(view : View){
        startActivity(Intent(this@NewsSites, NewSite::class.java))
        this@NewsSites.finish()
    }
    fun createDialog(name: String, url: String) {
        val builder = AlertDialog.Builder(this@NewsSites)
        builder
            .setTitle("Вы действительно хотите удалить $name из списка?")
            .setPositiveButton("Да") { _, _ ->
                val tinyDB : TinyDB = TinyDB()
                val list = tinyDB.getListObject("Sites", Sites::class.java)
                (list as ArrayList<Sites>).removeIf { it.siteName.equals(name) && it.siteUrl.equals(url)}
                tinyDB.putListObject("Sites",list)
                PlaceholderContent.update()
            }
            .setNegativeButton("Нет") { _, _ ->}
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}