package com.example.ronasit.api.weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Coord {
    @SerializedName("lon")
    @Expose
    var lon: Double? = null

    @SerializedName("lat")
    @Expose
    var lat: Double? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor()

    /**
     *
     * @param lon
     * @param lat
     */
    constructor(lon: Double?, lat: Double?) : super() {
        this.lon = lon
        this.lat = lat
    }

    fun withLon(lon: Double?): Coord {
        this.lon = lon
        return this
    }

    fun withLat(lat: Double?): Coord {
        this.lat = lat
        return this
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append(Coord::class.java.name).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[')
        sb.append("lon")
        sb.append('=')
        sb.append(if (lon == null) "<null>" else lon)
        sb.append(',')
        sb.append("lat")
        sb.append('=')
        sb.append(if (lat == null) "<null>" else lat)
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
        result = result * 31 + if (lon == null) 0 else lon.hashCode()
        result = result * 31 + if (lat == null) 0 else lat.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (other === this) {
            return true
        }
        if (other is Coord == false) {
            return false
        }
        val rhs = other
        return (lon === rhs.lon || lon != null && lon == rhs.lon) && (lat === rhs.lat || lat != null && lat == rhs.lat)
    }
}