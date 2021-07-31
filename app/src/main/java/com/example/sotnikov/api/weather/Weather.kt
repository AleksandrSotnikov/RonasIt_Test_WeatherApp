package com.example.sotnikov.api.weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Weather {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("main")
    @Expose
    var main: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("icon")
    @Expose
    var icon: String? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor()

    /**
     *
     * @param icon
     * @param description
     * @param main
     * @param id
     */
    constructor(id: Int?, main: String?, description: String?, icon: String?) : super() {
        this.id = id
        this.main = main
        this.description = description
        this.icon = icon
    }

    fun withId(id: Int?): Weather {
        this.id = id
        return this
    }

    fun withMain(main: String?): Weather {
        this.main = main
        return this
    }

    fun withDescription(description: String?): Weather {
        this.description = description
        return this
    }

    fun withIcon(icon: String?): Weather {
        this.icon = icon
        return this
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append(Weather::class.java.name).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[')
        sb.append("id")
        sb.append('=')
        sb.append(if (id == null) "<null>" else id)
        sb.append(',')
        sb.append("main")
        sb.append('=')
        sb.append(if (main == null) "<null>" else main)
        sb.append(',')
        sb.append("description")
        sb.append('=')
        sb.append(if (description == null) "<null>" else description)
        sb.append(',')
        sb.append("icon")
        sb.append('=')
        sb.append(if (icon == null) "<null>" else icon)
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
        result = result * 31 + if (icon == null) 0 else icon.hashCode()
        result = result * 31 + if (description == null) 0 else description.hashCode()
        result = result * 31 + if (main == null) 0 else main.hashCode()
        result = result * 31 + if (id == null) 0 else id.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (other === this) {
            return true
        }
        if (other is Weather == false) {
            return false
        }
        val rhs = other
        return (icon === rhs.icon || icon != null && icon == rhs.icon) && (description === rhs.description || description != null && description == rhs.description) && (main === rhs.main || main != null && main == rhs.main) && (id === rhs.id || id != null && id == rhs.id)
    }
}