package com.example.sotnikov.api.weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Wind {
    @SerializedName("speed")
    @Expose
    var speed: Double? = null

    @SerializedName("deg")
    @Expose
    var deg: Int? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor()

    /**
     *
     * @param deg
     * @param speed
     */
    constructor(speed: Double?, deg: Int?) : super() {
        this.speed = speed
        this.deg = deg
    }

    fun withSpeed(speed: Double?): Wind {
        this.speed = speed
        return this
    }

    fun withDeg(deg: Int?): Wind {
        this.deg = deg
        return this
    }

    fun withDirection(): String {
        if (this.deg!! in 338..360 || this.deg!! in 0..22) {
            return "северный"
        } else if (this.deg!! in 23..67) {
            return "северно-восточный"
        } else if (this.deg!! in 68..112) {
            return "Восточный"
        } else if (this.deg!! in 113..157) {
            return "юго-восточный"
        } else if (this.deg!! in 158..202) {
            return "южный"
        } else if (this.deg!! in 203..247) {
            return "юго-западный"
        } else if (this.deg!! in 248..292) {
            return "западный"
        } else if (this.deg!! in 293..337) {
            return "северо-западный"
        } else {
            return ""
        }
    }


    override fun toString(): String {
        val sb = StringBuilder()
        sb.append(Wind::class.java.name).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[')
        sb.append("speed")
        sb.append('=')
        sb.append(if (speed == null) "<null>" else speed)
        sb.append(',')
        sb.append("deg")
        sb.append('=')
        sb.append(if (deg == null) "<null>" else deg)
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
        result = result * 31 + if (speed == null) 0 else speed.hashCode()
        result = result * 31 + if (deg == null) 0 else deg.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (other === this) {
            return true
        }
        if (other is Wind == false) {
            return false
        }
        val rhs = other
        return (speed === rhs.speed || speed != null && speed == rhs.speed) && (deg === rhs.deg || deg != null && deg == rhs.deg)
    }
}