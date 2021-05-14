package com.example.ronasit.checker

import android.content.Context
import android.net.ConnectivityManager

class InternetChecker {
    companion object{
        @JvmStatic
        fun hasConnection(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            var wifiInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
            if (wifiInfo != null && wifiInfo.isConnected) {
                return true
            }
            wifiInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
            if (wifiInfo != null && wifiInfo.isConnected) {
                return true
            }
            wifiInfo = connectivityManager.activeNetworkInfo
            return wifiInfo != null && wifiInfo.isConnected
        }
    }
}