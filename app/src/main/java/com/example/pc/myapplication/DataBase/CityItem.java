package com.example.pc.myapplication.DataBase;

import android.view.LayoutInflater;

/**
 * Created by pc on 2018/10/24.
 */

public class CityItem {

    private int id;
    private String City_ID;
    private String City_EN;
    private String City_CN;
    private String Country_code;
    private String Country_EN;
    private String Country_CN;
    private String Province_EN;
    private String Province_CN;
    private String Admin_district_EN;
    private String Admin_district_CN;
    private String Latitude;
    private String Longitude;
    private String AD_code;

    public CityItem(){
        super();
        City_ID = "";
        City_EN = "";
        City_CN = "";
        Country_code = "";
        Country_EN = "";
        Country_CN = "";
        Province_EN = "";
        Province_CN = "";
        Admin_district_EN = "";
        Admin_district_CN = "";
        Latitude = "";
        Longitude = "";
        AD_code = "";
    }

    public CityItem(String City_ID, String City_EN, String City_CN, String Country_code, String Country_EN,
                    String Country_CN, String Province_EN, String Province_CN, String Admin_district_EN, String Admin_district_CN,
                    String Latitude, String Longitude, String AD_code){
        super();
        this.City_ID = City_ID;
        this.City_EN = City_EN;
        this.City_CN = City_CN;
        this.Country_code = Country_code;
        this.Country_EN = Country_EN;
        this.Country_CN = Country_CN;
        this.Province_EN = Province_EN;
        this.Province_CN = Province_CN;
        this.Admin_district_EN = Admin_district_EN;
        this.Admin_district_CN= Admin_district_CN;
        this.Latitude = Latitude;
        this.Longitude = Longitude;
        this.AD_code = AD_code;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getCity_ID(){
        return City_ID;
    }
    public void setCity_ID(String City_ID){
        this.City_ID = City_ID;
    }
    public String getCity_EN(){
        return City_EN;
    }
    public void setCity_EN(String City_EN){
        this.City_EN = City_EN;
    }
    public String getCity_CN(){
        return City_CN;
    }
    public void  setCity_CN(String City_CN){
        this.City_CN = City_CN;
    }
    public String getCountry_code(){
        return Country_code;
    }
    public void setCountry_code(String Country_code){
        this.Country_code = Country_code;
    }
    public String getCountry_EN(){
        return Country_EN;
    }
    public void setCountry_EN(String Country_EN){
        this.Country_EN = Country_EN;
    }
    public String getCountry_CN(){
        return Country_CN;
    }
    public void setCountry_CN(String Country_CN){
        this.Country_CN = Country_CN;
    }
    public String getProvince_EN(){
        return Province_EN;
    }
    public void setProvince_EN(String Province_EN){
        this.Province_EN = Province_EN;
    }
    public String getProvince_CN(){
        return Province_CN;
    }
    public void setProvince_CN(String Province_CN){
        this.Province_CN = Province_CN;
    }
    public String getAdmin_district_EN(){
        return Admin_district_EN;
    }
    public void setAdmin_district_EN(String Admin_district_EN){
        this.Admin_district_EN = Admin_district_EN;
    }
    public String getAdmin_district_CN(){
        return Admin_district_CN;
    }
    public void setAdmin_district_CN(String Admin_district_CN){
        this.Admin_district_CN = Admin_district_CN;
    }
    public String getLatitude(){
        return Latitude;
    }
    public void setLatitude(String Latitude){
        this.Latitude = Latitude;
    }
    public String getLongitude(){
        return Longitude;
    }
    public void setLongitude(String Longitude){
        this.Longitude = Longitude;
    }
    public String getAD_code(){
        return AD_code;
    }
    public void setAD_code(String AD_code){
        this.AD_code = AD_code;
    }

}
