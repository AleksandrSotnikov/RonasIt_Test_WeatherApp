package com.example.sotnikov.placeholder

import android.util.Log
import com.example.sotnikov.layout.MainActivity
import com.example.sotnikov.library.App
import com.example.sotnikov.library.TinyDB
import com.example.sotnikov.model.Sites
import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    var ITEMS: MutableList<PlaceholderItem> = ArrayList()

    /**
     * A map of sample (placeholder) items, by ID.
     */
    var ITEM_MAP: MutableMap<String, PlaceholderItem> = HashMap()

    init {
        // Add some sample items.
        Log.e("PlaceHolder","qazxcv")
        var tinyDB : TinyDB = TinyDB()
        var list = tinyDB.getListObject("Sites", Sites::class.java)
        if(list.size == 0){
            val site = Sites()
            site.siteName = "Добавьте свои сайты в данный список"
            list.add(site)
        }
        for (i in 1..list.size-1) {
            addItem(createPlaceholderItem(i,list))
        }
    }

    private fun addItem(item: PlaceholderItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    private fun createPlaceholderItem(position: Int,list : ArrayList<Any>): PlaceholderItem {
        return PlaceholderItem(position.toString(), (list[position] as Sites).siteName, makeDetails(position))
        //return PlaceholderItem(position.toString(), "Item " + position, makeDetails(position))
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    fun update(){
        ITEMS = ArrayList()
        ITEM_MAP = HashMap()
        Log.e("PlaceHolder","qazxcv")
        var tinyDB : TinyDB = TinyDB()
        var list = tinyDB.getListObject("Sites", Sites::class.java)
        if(list.size == 0){
            val site = Sites()
            site.siteName = "Добавьте свои сайты в данный список"
            list.add(site)
        }
        for (i in 1..list.size-1) {
            addItem(createPlaceholderItem(i,list))
        }
    }

    /**
     * A placeholder item representing a piece of content.
     */
    data class PlaceholderItem(val id: String, val content: String, val details: String) {
        override fun toString(): String = content
    }
}