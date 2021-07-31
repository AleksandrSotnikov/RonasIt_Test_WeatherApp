package com.example.sotnikov.api.weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ApiWeather {
    @SerializedName("coord")
    @Expose
    private var coord: Coord? = null

    @SerializedName("weather")
    @Expose
    private var weather: List<Weather>? = null

    @SerializedName("base")
    @Expose
    var base: String? = null

    @SerializedName("main")
    @Expose
    private var main: Main? = null

    @SerializedName("visibility")
    @Expose
    var visibility: Int? = null

    @SerializedName("wind")
    @Expose
    private var wind: Wind? = null

    @SerializedName("clouds")
    @Expose
    private var clouds: Clouds? = null

    @SerializedName("dt")
    @Expose
    var dt: Int? = null

    @SerializedName("sys")
    @Expose
    private var sys: Sys? = null

    @SerializedName("timezone")
    @Expose
    var timezone: Int? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("cod")
    @Expose
    var cod: Int? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor()

    /**
     *
     * @param visibility
     * @param timezone
     * @param main
     * @param clouds
     * @param sys
     * @param dt
     * @param coord
     * @param weather
     * @param name
     * @param cod
     * @param id
     * @param base
     * @param wind
     */
    constructor(
        coord: Coord?,
        weather: List<Weather>?,
        base: String?,
        main: Main?,
        visibility: Int?,
        wind: Wind?,
        clouds: Clouds?,
        dt: Int?,
        sys: Sys?,
        timezone: Int?,
        id: Int?,
        name: String?,
        cod: Int?
    ) : super() {
        this.coord = coord
        this.weather = weather
        this.base = base
        this.main = main
        this.visibility = visibility
        this.wind = wind
        this.clouds = clouds
        this.dt = dt
        this.sys = sys
        this.timezone = timezone
        this.id = id
        this.name = name
        this.cod = cod
    }

    fun getCoord(): Coord? {
        return coord
    }

    fun setCoord(coord: Coord?) {
        this.coord = coord
    }

    fun withCoord(coord: Coord?): ApiWeather {
        this.coord = coord
        return this
    }

    fun getWeather(): List<Weather>? {
        return weather
    }

    fun setWeather(weather: List<Weather>?) {
        this.weather = weather
    }

    fun withWeather(weather: List<Weather>?): ApiWeather {
        this.weather = weather
        return this
    }

    fun withBase(base: String?): ApiWeather {
        this.base = base
        return this
    }

    fun getMain(): Main? {
        return main
    }

    fun setMain(main: Main?) {
        this.main = main
    }

    fun withMain(main: Main?): ApiWeather {
        this.main = main
        return this
    }

    fun withVisibility(visibility: Int?): ApiWeather {
        this.visibility = visibility
        return this
    }

    fun getWind(): Wind? {
        return wind
    }

    fun setWind(wind: Wind?) {
        this.wind = wind
    }

    fun withWind(wind: Wind?): ApiWeather {
        this.wind = wind
        return this
    }

    fun getClouds(): Clouds? {
        return clouds
    }

    fun setClouds(clouds: Clouds?) {
        this.clouds = clouds
    }

    fun withClouds(clouds: Clouds?): ApiWeather {
        this.clouds = clouds
        return this
    }

    fun withDt(dt: Int?): ApiWeather {
        this.dt = dt
        return this
    }

    fun getSys(): Sys? {
        return sys
    }

    fun setSys(sys: Sys?) {
        this.sys = sys
    }

    fun withSys(sys: Sys?): ApiWeather {
        this.sys = sys
        return this
    }

    fun withTimezone(timezone: Int?): ApiWeather {
        this.timezone = timezone
        return this
    }

    fun withId(id: Int?): ApiWeather {
        this.id = id
        return this
    }

    fun withName(name: String?): ApiWeather {
        this.name = name
        return this
    }

    fun withCod(cod: Int?): ApiWeather {
        this.cod = cod
        return this
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append(ApiWeather::class.java.name).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[')
        sb.append("coord")
        sb.append('=')
        sb.append(if (coord == null) "<null>" else coord)
        sb.append(',')
        sb.append("weather")
        sb.append('=')
        sb.append(if (weather == null) "<null>" else weather)
        sb.append(',')
        sb.append("base")
        sb.append('=')
        sb.append(if (base == null) "<null>" else base)
        sb.append(',')
        sb.append("main")
        sb.append('=')
        sb.append(if (main == null) "<null>" else main)
        sb.append(',')
        sb.append("visibility")
        sb.append('=')
        sb.append(if (visibility == null) "<null>" else visibility)
        sb.append(',')
        sb.append("wind")
        sb.append('=')
        sb.append(if (wind == null) "<null>" else wind)
        sb.append(',')
        sb.append("clouds")
        sb.append('=')
        sb.append(if (clouds == null) "<null>" else clouds)
        sb.append(',')
        sb.append("dt")
        sb.append('=')
        sb.append(if (dt == null) "<null>" else dt)
        sb.append(',')
        sb.append("sys")
        sb.append('=')
        sb.append(if (sys == null) "<null>" else sys)
        sb.append(',')
        sb.append("timezone")
        sb.append('=')
        sb.append(if (timezone == null) "<null>" else timezone)
        sb.append(',')
        sb.append("id")
        sb.append('=')
        sb.append(if (id == null) "<null>" else id)
        sb.append(',')
        sb.append("name")
        sb.append('=')
        sb.append(if (name == null) "<null>" else name)
        sb.append(',')
        sb.append("cod")
        sb.append('=')
        sb.append(if (cod == null) "<null>" else cod)
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
        result = result * 31 + if (visibility == null) 0 else visibility.hashCode()
        result = result * 31 + if (timezone == null) 0 else timezone.hashCode()
        result = result * 31 + if (main == null) 0 else main.hashCode()
        result = result * 31 + if (clouds == null) 0 else clouds.hashCode()
        result = result * 31 + if (sys == null) 0 else sys.hashCode()
        result = result * 31 + if (dt == null) 0 else dt.hashCode()
        result = result * 31 + if (coord == null) 0 else coord.hashCode()
        result = result * 31 + if (weather == null) 0 else weather.hashCode()
        result = result * 31 + if (name == null) 0 else name.hashCode()
        result = result * 31 + if (cod == null) 0 else cod.hashCode()
        result = result * 31 + if (id == null) 0 else id.hashCode()
        result = result * 31 + if (base == null) 0 else base.hashCode()
        result = result * 31 + if (wind == null) 0 else wind.hashCode()
        return result
    }
}