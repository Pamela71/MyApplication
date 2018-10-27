package com.example.pc.myapplication.gson;

import java.util.List;

/**
 * Created by pc on 2018/10/25.
 */

public class AllCityInfo {

    private List<CityInfo> cityInfoList;
    private String status;

    public AllCityInfo(){
        super();
    }

    public AllCityInfo(List<CityInfo> cityInfoList, String status){
        super();
        this.cityInfoList = cityInfoList;
        this.status = status;
    }

    public List<CityInfo> getCityInfoList(){
        return cityInfoList;
    }

    public void setCityInfoList(List<CityInfo> cityInfoList){
        this.cityInfoList = cityInfoList;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
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
}
