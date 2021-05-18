package com.example.ronasit.api.weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Sys {
    @SerializedName("type")
    @Expose
    var type: Int? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("country")
    @Expose
    var country: String? = null

    @SerializedName("sunrise")
    @Expose
    var sunrise: Int? = null

    @SerializedName("sunset")
    @Expose
    var sunset: Int? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor()

    /**
     *
     * @param country
     * @param sunrise
     * @param sunset
     * @param id
     * @param type
     */
    constructor(type: Int?, id: Int?, country: String?, sunrise: Int?, sunset: Int?) : super() {
        this.type = type
        this.id = id
        this.country = country
        this.sunrise = sunrise
        this.sunset = sunset
    }

    fun withType(type: Int?): Sys {
        this.type = type
        return this
    }

    fun withId(id: Int?): Sys {
        this.id = id
        return this
    }

    fun withCountry(country: String?): Sys {
        this.country = country
        return this
    }

    fun withSunrise(sunrise: Int?): Sys {
        this.sunrise = sunrise
        return this
    }

    fun withSunset(sunset: Int?): Sys {
        this.sunset = sunset
        return this
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append(Sys::class.java.name).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[')
        sb.append("type")
        sb.append('=')
        sb.append(if (type == null) "<null>" else type)
        sb.append(',')
        sb.append("id")
        sb.append('=')
        sb.append(if (id == null) "<null>" else id)
        sb.append(',')
        sb.append("country")
        sb.append('=')
        sb.append(if (country == null) "<null>" else country)
        sb.append(',')
        sb.append("sunrise")
        sb.append('=')
        sb.append(if (sunrise == null) "<null>" else sunrise)
        sb.append(',')
        sb.append("sunset")
        sb.append('=')
        sb.append(if (sunset == null) "<null>" else sunset)
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
        result = result * 31 + if (country == null) 0 else country.hashCode()
        result = result * 31 + if (sunrise == null) 0 else sunrise.hashCode()
        result = result * 31 + if (id == null) 0 else id.hashCode()
        result = result * 31 + if (type == null) 0 else type.hashCode()
        result = result * 31 + if (sunset == null) 0 else sunset.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (other === this) {
            return true
        }
        if (other is Sys == false) {
            return false
        }
        val rhs = other
        return (country === rhs.country || country != null && country == rhs.country) && (sunrise === rhs.sunrise || sunrise != null && sunrise == rhs.sunrise) && (id === rhs.id || id != null && id == rhs.id) && (type === rhs.type || type != null && type == rhs.type) && (sunset === rhs.sunset || sunset != null && sunset == rhs.sunset)
    }
}