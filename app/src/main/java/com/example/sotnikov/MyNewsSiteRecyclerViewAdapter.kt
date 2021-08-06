package com.example.sotnikov

import android.app.Activity
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import com.example.sotnikov.placeholder.PlaceholderContent.PlaceholderItem
import com.example.sotnikov.databinding.FragmentItemBinding
import android.util.Log
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.sotnikov.layout.NewsSites

import com.example.sotnikov.layout.Web
import com.example.sotnikov.library.App.activity
import com.example.sotnikov.library.TinyDB
import com.example.sotnikov.model.Sites


/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyNewsSiteRecyclerViewAdapter(
    private val values: List<PlaceholderItem>,
) : RecyclerView.Adapter<MyNewsSiteRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tinyDB : TinyDB = TinyDB()
        val list = tinyDB.getListObject("Sites", Sites::class.java) as ArrayList<Sites>
        val item = values[position]
        holder.idView.text = item.id
        holder.contentView.text = item.content
        holder.contentView.setOnLongClickListener {
            delete((it as TextView).text.toString(),list.find { x -> x.siteName.equals((it as TextView).text.toString()) }?.siteUrl.toString())
            true
        }

        holder.contentView.setOnClickListener{
            v -> openWeb(list.find { x -> x.siteName.equals((v as TextView).text.toString()) }?.siteUrl.toString())
        }
    }

    fun delete(name : String,url:String){
        activity.createDialog(name,url)
    }

    fun openWeb(url:String){
        val intent = Intent(activity, Web::class.java)
        intent.putExtra("url",url)
        activity.startActivity(intent)
        activity.finish()
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}