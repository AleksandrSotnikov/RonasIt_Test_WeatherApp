package com.example.ronasit.checker

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.core.app.ActivityCompat


class LocationChecker {
    companion object {
        @JvmStatic
        fun getPermission(context: Context) {
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                val permissions = arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
                ActivityCompat.requestPermissions(context as Activity, permissions, 0)
            }
        }

        @JvmStatic
        fun checkEnabledGPS(locationManager: LocationManager?): Boolean {
            return locationManager?.isProviderEnabled(LocationManager.GPS_PROVIDER) ?: false
        }

        @JvmStatic
        fun checkEnabledNetwork(locationManager: LocationManager?): Boolean {
            return locationManager?.isProviderEnabled(LocationManager.NETWORK_PROVIDER) ?: false
        }
    }
}