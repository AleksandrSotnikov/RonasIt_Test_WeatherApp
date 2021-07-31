package com.example.sotnikov.api.weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Main {
    @SerializedName("temp")
    @Expose
    var temp: Double? = null

    @SerializedName("feels_like")
    @Expose
    var feelsLike: Double? = null

    @SerializedName("temp_min")
    @Expose
    var tempMin: Double? = null

    @SerializedName("temp_max")
    @Expose
    var tempMax: Double? = null

    @SerializedName("pressure")
    @Expose
    var pressure: Int? = null

    @SerializedName("humidity")
    @Expose
    var humidity: Int? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor()

    /**
     *
     * @param feelsLike
     * @param tempMax
     * @param temp
     * @param humidity
     * @param pressure
     * @param tempMin
     */
    constructor(
        temp: Double?,
        feelsLike: Double?,
        tempMin: Double?,
        tempMax: Double?,
        pressure: Int?,
        humidity: Int?
    ) : super() {
        this.temp = temp
        this.feelsLike = feelsLike
        this.tempMin = tempMin
        this.tempMax = tempMax
        this.pressure = pressure
        this.humidity = humidity
    }

    fun withTemp(temp: Double?): Main {
        this.temp = temp
        return this
    }

    fun withFeelsLike(feelsLike: Double?): Main {
        this.feelsLike = feelsLike
        return this
    }

    fun withTempMin(tempMin: Double?): Main {
        this.tempMin = tempMin
        return this
    }

    fun withTempMax(tempMax: Double?): Main {
        this.tempMax = tempMax
        return this
    }

    fun withPressure(pressure: Int?): Main {
        this.pressure = pressure
        return this
    }

    fun withHumidity(humidity: Int?): Main {
        this.humidity = humidity
        return this
    }

    fun withPressureMm(): Int {
        return (this.pressure!!.toDouble() * 0.750063755419211).toInt()
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append(Main::class.java.name).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[')
        sb.append("temp")
        sb.append('=')
        sb.append(if (temp == null) "<null>" else temp)
        sb.append(',')
        sb.append("feelsLike")
        sb.append('=')
        sb.append(if (feelsLike == null) "<null>" else feelsLike)
        sb.append(',')
        sb.append("tempMin")
        sb.append('=')
        sb.append(if (tempMin == null) "<null>" else tempMin)
        sb.append(',')
        sb.append("tempMax")
        sb.append('=')
        sb.append(if (tempMax == null) "<null>" else tempMax)
        sb.append(',')
        sb.append("pressure")
        sb.append('=')
        sb.append(if (pressure == null) "<null>" else pressure)
        sb.append(',')
        sb.append("humidity")
        sb.append('=')
        sb.append(if (humidity == null) "<null>" else humidity)
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
        result = result * 31 + if (feelsLike == null) 0 else feelsLike.hashCode()
        result = result * 31 + if (tempMax == null) 0 else tempMax.hashCode()
        result = result * 31 + if (temp == null) 0 else temp.hashCode()
        result = result * 31 + if (humidity == null) 0 else humidity.hashCode()
        result = result * 31 + if (pressure == null) 0 else pressure.hashCode()
        result = result * 31 + if (tempMin == null) 0 else tempMin.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (other === this) {
            return true
        }
        if (other is Main == false) {
            return false
        }
        val rhs = other
        return (feelsLike === rhs.feelsLike || feelsLike != null && feelsLike == rhs.feelsLike) && (tempMax === rhs.tempMax || tempMax != null && tempMax == rhs.tempMax) && (temp === rhs.temp || temp != null && temp == rhs.temp) && (humidity === rhs.humidity || humidity != null && humidity == rhs.humidity) && (pressure === rhs.pressure || pressure != null && pressure == rhs.pressure) && (tempMin === rhs.tempMin || tempMin != null && tempMin == rhs.tempMin)
    }
}