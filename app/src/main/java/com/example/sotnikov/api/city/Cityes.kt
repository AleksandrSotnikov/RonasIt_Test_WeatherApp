package com.example.sotnikov.api.city

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Cityes {
    @SerializedName("cityes")
    @Expose
    var cityes: ArrayList<City>? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor()

    /**
     *
     * @param city
     */
    constructor(city: ArrayList<City>?) : super() {
        cityes = city
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append(City::class.java.name).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[')
        sb.append("city")
        sb.append('=')
        sb.append(if (cityes == null) "<null>" else cityes)
        sb.append(',')
        if (sb[sb.length - 1] == ',') {
            sb.setCharAt(sb.length - 1, ']')
        } else {
            sb.append(']')
        }
        return sb.toString()
    }

    override fun hashCode(): Int {
        var result = 1
        result = result * 31 + if (cityes == null) 0 else cityes.hashCode()
        return result
    }
}