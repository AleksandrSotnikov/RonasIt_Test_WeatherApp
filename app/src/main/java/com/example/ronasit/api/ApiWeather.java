
package com.example.ronasit.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiWeather {

    @SerializedName("coord")
    @Expose
    private Coord coord;
    @SerializedName("weather")
    @Expose
    private List<Weather> weather = null;
    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("main")
    @Expose
    private Main main;
    @SerializedName("visibility")
    @Expose
    private Integer visibility;
    @SerializedName("wind")
    @Expose
    private Wind wind;
    @SerializedName("clouds")
    @Expose
    private Clouds clouds;
    @SerializedName("dt")
    @Expose
    private Integer dt;
    @SerializedName("sys")
    @Expose
    private Sys sys;
    @SerializedName("timezone")
    @Expose
    private Integer timezone;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cod")
    @Expose
    private Integer cod;

    /**
     * No args constructor for use in serialization
     *
     */
    public ApiWeather() {
    }

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
    public ApiWeather(Coord coord, List<Weather> weather, String base, Main main, Integer visibility, Wind wind, Clouds clouds, Integer dt, Sys sys, Integer timezone, Integer id, String name, Integer cod) {
        super();
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.timezone = timezone;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public ApiWeather withCoord(Coord coord) {
        this.coord = coord;
        return this;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public ApiWeather withWeather(List<Weather> weather) {
        this.weather = weather;
        return this;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public ApiWeather withBase(String base) {
        this.base = base;
        return this;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public ApiWeather withMain(Main main) {
        this.main = main;
        return this;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public ApiWeather withVisibility(Integer visibility) {
        this.visibility = visibility;
        return this;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public ApiWeather withWind(Wind wind) {
        this.wind = wind;
        return this;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public ApiWeather withClouds(Clouds clouds) {
        this.clouds = clouds;
        return this;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public ApiWeather withDt(Integer dt) {
        this.dt = dt;
        return this;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public ApiWeather withSys(Sys sys) {
        this.sys = sys;
        return this;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public ApiWeather withTimezone(Integer timezone) {
        this.timezone = timezone;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ApiWeather withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ApiWeather withName(String name) {
        this.name = name;
        return this;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public ApiWeather withCod(Integer cod) {
        this.cod = cod;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiWeather.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("coord");
        sb.append('=');
        sb.append(((this.coord == null) ? "<null>" : this.coord));
        sb.append(',');
        sb.append("weather");
        sb.append('=');
        sb.append(((this.weather == null) ? "<null>" : this.weather));
        sb.append(',');
        sb.append("base");
        sb.append('=');
        sb.append(((this.base == null) ? "<null>" : this.base));
        sb.append(',');
        sb.append("main");
        sb.append('=');
        sb.append(((this.main == null) ? "<null>" : this.main));
        sb.append(',');
        sb.append("visibility");
        sb.append('=');
        sb.append(((this.visibility == null) ? "<null>" : this.visibility));
        sb.append(',');
        sb.append("wind");
        sb.append('=');
        sb.append(((this.wind == null) ? "<null>" : this.wind));
        sb.append(',');
        sb.append("clouds");
        sb.append('=');
        sb.append(((this.clouds == null) ? "<null>" : this.clouds));
        sb.append(',');
        sb.append("dt");
        sb.append('=');
        sb.append(((this.dt == null) ? "<null>" : this.dt));
        sb.append(',');
        sb.append("sys");
        sb.append('=');
        sb.append(((this.sys == null) ? "<null>" : this.sys));
        sb.append(',');
        sb.append("timezone");
        sb.append('=');
        sb.append(((this.timezone == null) ? "<null>" : this.timezone));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("cod");
        sb.append('=');
        sb.append(((this.cod == null) ? "<null>" : this.cod));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.visibility == null) ? 0 : this.visibility.hashCode()));
        result = ((result * 31) + ((this.timezone == null) ? 0 : this.timezone.hashCode()));
        result = ((result * 31) + ((this.main == null) ? 0 : this.main.hashCode()));
        result = ((result * 31) + ((this.clouds == null) ? 0 : this.clouds.hashCode()));
        result = ((result * 31) + ((this.sys == null) ? 0 : this.sys.hashCode()));
        result = ((result * 31) + ((this.dt == null) ? 0 : this.dt.hashCode()));
        result = ((result * 31) + ((this.coord == null) ? 0 : this.coord.hashCode()));
        result = ((result * 31) + ((this.weather == null) ? 0 : this.weather.hashCode()));
        result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((result * 31) + ((this.cod == null) ? 0 : this.cod.hashCode()));
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((result * 31) + ((this.base == null) ? 0 : this.base.hashCode()));
        result = ((result * 31) + ((this.wind == null) ? 0 : this.wind.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ApiWeather) == false) {
            return false;
        }
        ApiWeather rhs = ((ApiWeather) other);
        return ((((((((((((((this.visibility == rhs.visibility) || ((this.visibility != null) && this.visibility.equals(rhs.visibility))) && ((this.timezone == rhs.timezone) || ((this.timezone != null) && this.timezone.equals(rhs.timezone)))) && ((this.main == rhs.main) || ((this.main != null) && this.main.equals(rhs.main)))) && ((this.clouds == rhs.clouds) || ((this.clouds != null) && this.clouds.equals(rhs.clouds)))) && ((this.sys == rhs.sys) || ((this.sys != null) && this.sys.equals(rhs.sys)))) && ((this.dt == rhs.dt) || ((this.dt != null) && this.dt.equals(rhs.dt)))) && ((this.coord == rhs.coord) || ((this.coord != null) && this.coord.equals(rhs.coord)))) && ((this.weather == rhs.weather) || ((this.weather != null) && this.weather.equals(rhs.weather)))) && ((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name)))) && ((this.cod == rhs.cod) || ((this.cod != null) && this.cod.equals(rhs.cod)))) && ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id)))) && ((this.base == rhs.base) || ((this.base != null) && this.base.equals(rhs.base)))) && ((this.wind == rhs.wind) || ((this.wind != null) && this.wind.equals(rhs.wind))));
    }

}
