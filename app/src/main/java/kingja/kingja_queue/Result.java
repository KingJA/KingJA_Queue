package kingja.kingja_queue;

/**
 * 项目名称：常用工具类
 * 类描述：TODO
 * 创建人：KingJA
 * 创建时间：2016/7/1320:09
 * 修改备注：
 */
public class Result {
    private double lon;
    private int level;
    private String address;
    private String cityName;
    private int alevel;
    private double lat;

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getAlevel() {
        return alevel;
    }

    public void setAlevel(int alevel) {
        this.alevel = alevel;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Result{" +
                "lon=" + lon +
                ", level=" + level +
                ", address='" + address + '\'' +
                ", cityName='" + cityName + '\'' +
                ", alevel=" + alevel +
                ", lat=" + lat +
                '}';
    }
}
