package com.example.pc.myapplication.gson;

import java.util.List;

/**
 * Created by pc on 2018/10/26.
 */

public class NowWeatherInfo {

    private List<NowWeatherInfo.WeatherInfo> weatherInfoList;
    private List<NowWeatherInfo.CityInfo> cityInfoList;
    private String status;
    private List<NowWeatherInfo.UpdateMsg> updateMsgList;

    public NowWeatherInfo(){
        super();
    }

    public NowWeatherInfo(List<NowWeatherInfo.WeatherInfo> weatherInfoList,List<NowWeatherInfo.CityInfo> cityInfoList, String status, List<NowWeatherInfo.UpdateMsg> updateMsgList){
        super();
        this.weatherInfoList = weatherInfoList;
        this.cityInfoList = cityInfoList;
        this.status = status;
        this.updateMsgList = updateMsgList;
    }

    public List<NowWeatherInfo.WeatherInfo> getWeatherInfoList(){
        return weatherInfoList;
    }

    public void setWeatherInfoList(List<NowWeatherInfo.WeatherInfo> weatherInfoList){
        this.weatherInfoList = weatherInfoList;
    }

    public List<NowWeatherInfo.CityInfo> getCityInfoList(){
        return cityInfoList;
    }

    public void setCityInfoList(List<NowWeatherInfo.CityInfo> cityInfoList){
        this.cityInfoList = cityInfoList;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public List<NowWeatherInfo.UpdateMsg> getUpdateMsgList(){
        return updateMsgList;
    }
    public void setUpdateMsgList(List<NowWeatherInfo.UpdateMsg> updateMsgList){
        this.updateMsgList = updateMsgList;
    }

    public class CityInfo {

        private String admin_area;
        private String cid;
        private String cnty;
        private String lat;
        private String location;
        private String lon;
        private String parent_city;
        private String tz;

        public CityInfo(){
            super();
        }

        public CityInfo(String admin_area, String cid, String cnty, String lat, String location,
                        String lon, String parent_city, String tz){
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

        public String getAdmin_area(){
            return admin_area;
        }
        public void setAdmin_area(int id){
            this.admin_area = admin_area;
        }
        public String getCid(){
            return cid;
        }
        public void setCid(String City_ID){
            this.cid = cid;
        }
        public String getCnty(){
            return cnty;
        }
        public void setCnty(String City_EN){
            this.cnty = cnty;
        }
        public String getLat(){
            return lat;
        }
        public void  setLat(String City_CN){
            this.lat = lat;
        }
        public String getLocation(){
            return location;
        }
        public void setLocation(String Country_code){
            this.location = location;
        }
        public String getLon(){
            return lon;
        }
        public void setLon(String Country_EN){
            this.lon = lon;
        }
        public String getParent_city(){
            return parent_city;
        }
        public void setParent_city(String Country_CN){
            this.parent_city = parent_city;
        }
        public String getTz(){
            return tz;
        }
        public void setTz(String Province_EN){
            this.tz = tz;
        }

    }

    public class WeatherInfo {

        private String cloud;
        private String cond_code;
        private String cond_txt;
        private String fl;
        private String hum;
        private String pcpn;    //降水量
        private String pres;   //大气压强
        private String tmp;
        private String vis;    //能见度
        private String wind_deg;   //风向360角度
        private String wind_dir;    //风向
        private String wind_sc;    //风力
        private String wind_spd;   //风速，公里/小时


        public WeatherInfo(){
            super();
        }

        public WeatherInfo(String cloud, String cond_code, String cond_txt, String fl, String hum, String pcpn, String pres, String tmp,
                           String vis, String wind_deg, String wind_dir, String wind_sc, String wind_spd){
            super();
            this.cloud = cloud;
            this.cond_code = cond_code;
            this.cond_txt = cond_txt;
            this.fl = fl;
            this.hum = hum;
            this.pcpn = pcpn;
            this.pres = pres;
            this.tmp = tmp;
            this.vis = vis;
            this.wind_deg = wind_deg;
            this.wind_dir = wind_dir;
            this.wind_sc = wind_sc;
            this.wind_spd = wind_spd;
        }

        public String getCloud(){
            return cloud;
        }
        public void setCloud(String cloud){
            this.cloud = cloud;
        }
        public String getCond_code(){
            return cond_code;
        }
        public void setCond_code(String cond_code){
            this.cond_code = cond_code;
        }
        public String getCond_txt(){
            return cond_txt;
        }
        public void setCond_txt(String cond_txt){
            this.cond_txt = cond_txt;
        }
        public String getFl(){
            return fl;
        }
        public void setFl(String fl){
            this.fl = fl;
        }
        public String getHum(){
            return hum;
        }
        public void setHum(String hum){
            this.hum = hum;
        }
        public String getPcpn(){
            return pcpn;
        }
        public void setPcpn(String pcpn){
            this.pcpn = pcpn;
        }
        public String getPres(){
            return pres;
        }
        public void setPres(String pres){
            this.pres = pres;
        }
        public String getTmp(){
            return tmp;
        }
        public void setTmp(String tmp){
            this.tmp = tmp;
        }
        public String getVis(){
            return vis;
        }
        public void setVis(String vis){
            this.vis = vis;
        }
        public String getWind_deg(){
            return wind_deg;
        }
        public void setWind_deg(String wind_deg){
            this.wind_deg = wind_deg;
        }
        public String getWind_dir(){
            return wind_dir;
        }
        public void setWind_dir(String wind_dir){
            this.wind_dir = wind_dir;
        }
        public String getWind_sc(){
            return wind_sc;
        }
        public void setWind_sc(String wind_sc){
            this.wind_sc = wind_sc;
        }
        public String getWind_spd(){
            return wind_spd;
        }
        public void setWind_spd(String wind_spd){
            this.wind_spd = wind_spd;
        }
    }

    public class UpdateMsg {

        private String loc;
        private String utc;

        public UpdateMsg(){
            super();
        }

        public UpdateMsg(String loc, String utc){
            super();
            this.loc = loc;
            this.utc = utc;
        }

        public String getLoc(){
            return loc;
        }
        public void setLoc(String loc){
            this.loc = loc;
        }
        public String getUtc(){
            return utc;
        }
        public void setUtc(String utc){
            this.utc = utc;
        }
    }

}
