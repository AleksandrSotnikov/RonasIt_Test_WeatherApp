package com.example.ronasit.api.city

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class City {
    @SerializedName("name")
    @Expose
    var name: String? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor()

    /**
     *
     * @param name
     */
    constructor(name: String?) : super() {
        this.name = name
    }

    override fun toString(): String {

        return this.name.toString()
    }

    override fun hashCode(): Int {
        var result = 1
        result = result * 31 + if (name == null) 0 else name.hashCode()
        return result
    }
}