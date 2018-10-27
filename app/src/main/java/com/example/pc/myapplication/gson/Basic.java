package com.example.pc.myapplication.gson;

/**
 * Created by pc on 2018/10/27.
 */

public class Basic {

    private String admin_area;
    private String cid;
    private String cnty;
    private String lat;
    private String location;
    private String lon;
    private String parent_city;
    private String tz;

    public Basic(){
        super();
    }
    public Basic(String admin_area, String cid, String cnty, String lat, String location, String lon, String parent_city, String tz){
        super();
        this.admin_area = admin_area;
        this.cid = cid;
        this.cnty = cnty;
        this.lat = lat;
        this.location = location;
        this.lon = lon;
        this.parent_city = parent_city;
        this.tz = tz;
    }
    public void setAdmin_area(String admin_area) {
        this.admin_area = admin_area;
    }
    public String getAdmin_area() {
        return admin_area;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
    public String getCid() {
        return cid;
    }

    public void setCnty(String cnty) {
        this.cnty = cnty;
    }
    public String getCnty() {
        return cnty;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
    public String getLat() {
        return lat;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public String getLocation() {
        return location;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
    public String getLon() {
        return lon;
    }

    public void setParent_city(String parent_city) {
        this.parent_city = parent_city;
    }
    public String getParent_city() {
        return parent_city;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }
    public String getTz() {
        return tz;
    }

}
