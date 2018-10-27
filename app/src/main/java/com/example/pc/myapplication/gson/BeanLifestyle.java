package com.example.pc.myapplication.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pc on 2018/10/28.
 */

public class BeanLifestyle {

    private List<Lifestyle> lifestyle;
    private Basic basic;
    private String status;
    private Update update;
    public void setLifestyle(List<Lifestyle> lifestyle) {
        this.lifestyle = lifestyle;
    }
    public List<Lifestyle> getLifestyle() {
        return lifestyle;
    }

    public void setBasic(Basic basic) {
        this.basic = basic;
    }
    public Basic getBasic() {
        return basic;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    public void setUpdate(Update update) {
        this.update = update;
    }
    public Update getUpdate() {
        return update;
    }

    public class Lifestyle {

        private String brf;
        private String txt;
        private String type;
        public void setBrf(String brf) {
            this.brf = brf;
        }
        public String getBrf() {
            return brf;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }
        public String getTxt() {
            return txt;
        }

        public void setType(String type) {
            this.type = type;
        }
        public String getType() {
            return type;
        }

    }

    public class Basic {

        @SerializedName("admin_area")
        private String adminArea;
        private String cid;
        private String cnty;
        private String lat;
        private String location;
        private String lon;
        @SerializedName("parent_city")
        private String parentCity;
        private String tz;
        public void setAdminArea(String adminArea) {
            this.adminArea = adminArea;
        }
        public String getAdminArea() {
            return adminArea;
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

        public void setParentCity(String parentCity) {
            this.parentCity = parentCity;
        }
        public String getParentCity() {
            return parentCity;
        }

        public void setTz(String tz) {
            this.tz = tz;
        }
        public String getTz() {
            return tz;
        }

    }

    public class Update {

        private String loc;
        private String utc;
        public void setLoc(String loc) {
            this.loc = loc;
        }
        public String getLoc() {
            return loc;
        }

        public void setUtc(String utc) {
            this.utc = utc;
        }
        public String getUtc() {
            return utc;
        }

    }

}
