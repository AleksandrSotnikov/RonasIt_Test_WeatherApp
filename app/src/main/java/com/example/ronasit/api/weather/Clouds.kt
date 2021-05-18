package com.example.ronasit.api.weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Clouds {
    @SerializedName("all")
    @Expose
    var all: Int? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor()

    /**
     *
     * @param all
     */
    constructor(all: Int?) : super() {
        this.all = all
    }

    fun withAll(all: Int?): Clouds {
        this.all = all
        return this
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append(Clouds::class.java.name).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[')
        sb.append("all")
        sb.append('=')
        sb.append(if (all == null) "<null>" else all)
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
        result = result * 31 + if (all == null) 0 else all.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (other === this) {
            return true
        }
        if (other is Clouds == false) {
            return false
        }
        val rhs = other
        return all === rhs.all || all != null && all == rhs.all
    }
}