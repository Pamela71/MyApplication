package com.example.pc.myapplication.DataBase;

/**
 * Created by pc on 2018/10/26.
 */

public class WeatherItem {

    private String status;

    private String cond_code;
    private String cond_txt;
    private String fl;
    private String hum;
    private String tmp;
    private String wind_dir;    //风向
    private String wind_sc;    //风力
    private String wind_spd;   //风速，公里/小时

    private String cid;
    private String location;

    private String utc;

    private String pre_tmp_min0;
    private String pre_tmp_max0;
    private String pre_date0;
    private String pre_cond_txt_d0;
    private String pre_cond_code_d0;
    private String pre_cond_code_n0;
    private String pre_cond_txt_n0;

    private String pre_tmp_min1;
    private String pre_tmp_max1;
    private String pre_date1;
    private String pre_cond_txt_d1;
    private String pre_cond_code_d1;
    private String pre_cond_code_n1;
    private String pre_cond_txt_n1;

    private String pre_tmp_min2;
    private String pre_tmp_max2;
    private String pre_date2;
    private String pre_cond_txt_d2;
    private String pre_cond_code_d2;
    private String pre_cond_code_n2;
    private String pre_cond_txt_n2;

    private String pre_tmp_min3;
    private String pre_tmp_max3;
    private String pre_date3;
    private String pre_cond_txt_d3;
    private String pre_cond_code_d3;
    private String pre_cond_code_n3;
    private String pre_cond_txt_n3;

    private String pre_tmp_min4;
    private String pre_tmp_max4;
    private String pre_date4;
    private String pre_cond_txt_d4;
    private String pre_cond_code_d4;
    private String pre_cond_code_n4;
    private String pre_cond_txt_n4;

    private String pre_tmp_min5;
    private String pre_tmp_max5;
    private String pre_date5;
    private String pre_cond_txt_d5;
    private String pre_cond_code_d5;
    private String pre_cond_code_n5;
    private String pre_cond_txt_n5;

    private String pre_tmp_min6;
    private String pre_tmp_max6;
    private String pre_date6;
    private String pre_cond_txt_d6;
    private String pre_cond_code_d6;
    private String pre_cond_code_n6;
    private String pre_cond_txt_n6;


    public WeatherItem(){
        super();
    }

    public WeatherItem(String status, String cond_code, String cond_txt, String fl, String hum, String tmp, String wind_dir, String wind_sc,
                       String wind_spd, String cid, String location, String utc, String pre_tmp_min0,String pre_tmp_max0,String pre_date0,
                       String pre_cond_txt_d0, String pre_cond_code_d0, String pre_cond_code_n0, String pre_cond_txt_n0, String pre_tmp_min1,
                       String pre_tmp_max1,String pre_date1, String pre_cond_txt_d1, String pre_cond_code_d1, String pre_cond_code_n1,
                       String pre_cond_txt_n1, String pre_tmp_min2,String pre_tmp_max2,String pre_date2, String pre_cond_txt_d2, String pre_cond_code_d2,
                       String pre_cond_code_n2, String pre_cond_txt_n2, String pre_tmp_min3,String pre_tmp_max3,String pre_date3, String pre_cond_txt_d3,
                       String pre_cond_code_d3, String pre_cond_code_n3, String pre_cond_txt_n3, String pre_tmp_min4, String pre_tmp_max4,String pre_date4,
                       String pre_cond_txt_d4, String pre_cond_code_d4, String pre_cond_code_n4, String pre_cond_txt_n4, String pre_tmp_min6,
                       String pre_tmp_max6,String pre_date6, String pre_cond_txt_d6, String pre_cond_code_d6, String pre_cond_code_n6, String pre_cond_txt_n6){
        super();
        this.status = status;
        this.cond_code = cond_code;
        this.cond_txt = cond_txt;
        this.fl = fl;
        this.hum = hum;
        this.tmp= tmp;
        this.wind_dir = wind_dir;
        this.wind_sc = wind_sc;
        this.wind_spd = wind_spd;
        this.cid = cid;
        this.location = location;
        this.utc = utc;

        this.pre_tmp_min0 = pre_tmp_min0;
        this.pre_tmp_max0 = pre_tmp_max0;
        this.pre_date0 = pre_date0;
        this.pre_cond_txt_d0 = pre_cond_txt_d0;
        this.pre_cond_code_d0 = pre_cond_code_d0;
        this.pre_cond_code_n0 = pre_cond_code_n0;
        this.pre_cond_txt_n0 = pre_cond_txt_n0;

        this.pre_tmp_min1 = pre_tmp_min1;
        this.pre_tmp_max1 = pre_tmp_max1;
        this.pre_date1 = pre_date1;
        this.pre_cond_txt_d1 = pre_cond_txt_d1;
        this.pre_cond_code_d1 = pre_cond_code_d1;
        this.pre_cond_code_n1 = pre_cond_code_n1;
        this.pre_cond_txt_n1 = pre_cond_txt_n1;

        this.pre_tmp_min2 = pre_tmp_min2;
        this.pre_tmp_max2 = pre_tmp_max2;
        this.pre_date2 = pre_date2;
        this.pre_cond_txt_d2 = pre_cond_txt_d2;
        this.pre_cond_code_d2 = pre_cond_code_d2;
        this.pre_cond_code_n2 = pre_cond_code_n2;
        this.pre_cond_txt_n2 = pre_cond_txt_n2;

        this.pre_tmp_min3 = pre_tmp_min3;
        this.pre_tmp_max3 = pre_tmp_max3;
        this.pre_date3 = pre_date3;
        this.pre_cond_txt_d3 = pre_cond_txt_d3;
        this.pre_cond_code_d3 = pre_cond_code_d3;
        this.pre_cond_code_n3 = pre_cond_code_n3;
        this.pre_cond_txt_n3 = pre_cond_txt_n3;

        this.pre_tmp_min4 = pre_tmp_min4;
        this.pre_tmp_max4 = pre_tmp_max4;
        this.pre_date4 = pre_date4;
        this.pre_cond_txt_d4 = pre_cond_txt_d4;
        this.pre_cond_code_d4 = pre_cond_code_d4;
        this.pre_cond_code_n4 = pre_cond_code_n4;
        this.pre_cond_txt_n4 = pre_cond_txt_n4;

        this.pre_tmp_min5 = pre_tmp_min5;
        this.pre_tmp_max5 = pre_tmp_max5;
        this.pre_date5 = pre_date5;
        this.pre_cond_txt_d5 = pre_cond_txt_d5;
        this.pre_cond_code_d5 = pre_cond_code_d5;
        this.pre_cond_code_n5 = pre_cond_code_n5;
        this.pre_cond_txt_n5 = pre_cond_txt_n5;

        this.pre_tmp_min6 = pre_tmp_min6;
        this.pre_tmp_max6 = pre_tmp_max6;
        this.pre_date6 = pre_date6;
        this.pre_cond_txt_d6 = pre_cond_txt_d6;
        this.pre_cond_code_d6 = pre_cond_code_d6;
        this.pre_cond_code_n6 = pre_cond_code_n6;
        this.pre_cond_txt_n6 = pre_cond_txt_n6;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
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
    public String getTmp(){
        return tmp;
    }
    public void setTmp(String tmp){
        this.tmp = tmp;
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


    public String getCid(){
        return cid;
    }
    public void setCid(String City_ID){
        this.cid = cid;
    }
    public String getLocation(){
        return location;
    }
    public void setLocation(String Country_code){
        this.location = location;
    }

    public String getUtc(){
        return utc;
    }
    public void setUtc(String utc){
        this.utc = utc;
    }


    public String getPre_tmp_min0(){
        return pre_tmp_min0;
    }
    public void setPre_tmp_min0(String pre_tmp_min0){
        this.pre_tmp_min0 = pre_tmp_min0;
    }
    public String getPre_tmp_max0(){
        return pre_tmp_max0;
    }
    public void setPre_tmp_max0(String pre_tmp_max0){
        this.pre_tmp_max0 = pre_tmp_max0;
    }
    public String getPre_date0(){
        return pre_date0;
    }
    public void setPre_date0(String pre_date0){
        this.pre_date0 = pre_date0;
    }
    public String getPre_cond_txt_d0(){
        return pre_cond_txt_d0;
    }
    public void setPre_cond_txt_d0(String pre_cond_txt_d0){
        this.pre_cond_txt_d0 = pre_cond_txt_d0;
    }
    public String getPre_cond_code_d0() {
        return pre_cond_code_d0;
    }
    public void setPre_cond_code_d0(String pre_cond_code_d0){
        this.pre_cond_code_d0 = pre_cond_code_d0;
    }
    public String getPre_cond_txt_n0(){
        return pre_cond_txt_n0;
    }
    public void setPre_cond_code_n0(String pre_cond_code_d0){
        this.pre_cond_code_n0 = pre_cond_code_n0;
    }
    public String getPre_cond_code_n0(){
        return pre_cond_code_n0;
    }
    public void setPre_cond_txt_n0(String pre_cond_code_n0){
        this.pre_cond_txt_n0 = pre_cond_txt_n0;
    }

    public String getPre_tmp_min1(){
        return pre_tmp_min1;
    }
    public void setPre_tmp_min1(String pre_tmp_min1){
        this.pre_tmp_min1 = pre_tmp_min1;
    }
    public String getPre_tmp_max1(){
        return pre_tmp_max1;
    }
    public void setPre_tmp_max1(String pre_tmp_max1){
        this.pre_tmp_max1 = pre_tmp_max1;
    }
    public String getPre_date1(){
        return pre_date1;
    }
    public void setPre_date1(String pre_date1){
        this.pre_date1 = pre_date1;
    }
    public String getPre_cond_txt_d1(){
        return pre_cond_txt_d1;
    }
    public void setPre_cond_txt_d1(String pre_cond_txt_d1){
         this.pre_cond_txt_d1 = pre_cond_txt_d1;
    }
    public String getPre_cond_code_d1() {
        return pre_cond_code_d1;
    }
    public void setPre_cond_code_d1(String pre_cond_code_d1){
        this.pre_cond_code_d1 = pre_cond_code_d1;
    }
    public String getPre_cond_txt_n1(){
        return pre_cond_txt_n1;
    }
    public void setPre_cond_code_n1(String pre_cond_code_d1){
        this.pre_cond_code_n1 = pre_cond_code_n1;
    }
    public String getPre_cond_code_n1(){
        return pre_cond_code_n1;
    }
    public void setPre_cond_txt_n1(String pre_cond_code_n1){
        this.pre_cond_txt_n1 = pre_cond_txt_n1;
    }

    public String getPre_tmp_min2(){
        return pre_tmp_min2;
    }
    public void setPre_tmp_min2(String pre_tmp_min2){
        this.pre_tmp_min2 = pre_tmp_min2;
    }
    public String getPre_tmp_max2(){
        return pre_tmp_max2;
    }
    public void setPre_tmp_max2(String pre_tmp_max2){
        this.pre_tmp_max2 = pre_tmp_max2;
    }
    public String getPre_date2(){
        return pre_date2;
    }
    public void setPre_date2(String pre_date2){
        this.pre_date2 = pre_date2;
    }
    public String getPre_cond_txt_d2(){
        return pre_cond_txt_d2;
    }
    public void setPre_cond_txt_d2(String pre_cond_txt_d2){
        this.pre_cond_txt_d2 = pre_cond_txt_d2;
    }
    public String getPre_cond_code_d2() {
        return pre_cond_code_d2;
    }
    public void setPre_cond_code_d2(String pre_cond_code_d2){
        this.pre_cond_code_d2 = pre_cond_code_d2;
    }
    public String getPre_cond_txt_n2(){
        return pre_cond_txt_n2;
    }
    public void setPre_cond_code_n2(String pre_cond_code_d2){
        this.pre_cond_code_n2 = pre_cond_code_n2;
    }
    public String getPre_cond_code_n2(){
        return pre_cond_code_n2;
    }
    public void setPre_cond_txt_n2(String pre_cond_code_n2){
        this.pre_cond_txt_n2 = pre_cond_txt_n2;
    }

    public String getPre_tmp_min3(){
        return pre_tmp_min3;
    }
    public void setPre_tmp_min3(String pre_tmp_min3){
        this.pre_tmp_min3 = pre_tmp_min3;
    }
    public String getPre_tmp_max3(){
        return pre_tmp_max3;
    }
    public void setPre_tmp_max3(String pre_tmp_max3){
        this.pre_tmp_max3 = pre_tmp_max3;
    }
    public String getPre_date3(){
        return pre_date3;
    }
    public void setPre_date3(String pre_date3){
        this.pre_date3 = pre_date3;
    }
    public String getPre_cond_txt_d3(){
        return pre_cond_txt_d3;
    }
    public void setPre_cond_txt_d3(String pre_cond_txt_d3){
        this.pre_cond_txt_d3 = pre_cond_txt_d3;
    }
    public String getPre_cond_code_d3() {
        return pre_cond_code_d3;
    }
    public void setPre_cond_code_d3(String pre_cond_code_d3){
        this.pre_cond_code_d3 = pre_cond_code_d3;
    }
    public String getPre_cond_txt_n3(){
        return pre_cond_txt_n3;
    }
    public void setPre_cond_code_n3(String pre_cond_code_d3){
        this.pre_cond_code_n3 = pre_cond_code_n3;
    }
    public String getPre_cond_code_n3(){
        return pre_cond_code_n3;
    }
    public void setPre_cond_txt_n3(String pre_cond_code_n3){
        this.pre_cond_txt_n3 = pre_cond_txt_n3;
    }

    public String getPre_tmp_min4(){
        return pre_tmp_min4;
    }
    public void setPre_tmp_min4(String pre_tmp_min4){
        this.pre_tmp_min4 = pre_tmp_min4;
    }
    public String getPre_tmp_max4(){
        return pre_tmp_max4;
    }
    public void setPre_tmp_max4(String pre_tmp_max4){
        this.pre_tmp_max4 = pre_tmp_max4;
    }
    public String getPre_date4(){
        return pre_date4;
    }
    public void setPre_date4(String pre_date4){
        this.pre_date4 = pre_date4;
    }
    public String getPre_cond_txt_d4(){
        return pre_cond_txt_d4;
    }
    public void setPre_cond_txt_d4(String pre_cond_txt_d4){
        this.pre_cond_txt_d4 = pre_cond_txt_d4;
    }
    public String getPre_cond_code_d4() {
        return pre_cond_code_d4;
    }
    public void setPre_cond_code_d4(String pre_cond_code_d4){
        this.pre_cond_code_d4 = pre_cond_code_d4;
    }
    public String getPre_cond_txt_n4(){
        return pre_cond_txt_n4;
    }
    public void setPre_cond_code_n4(String pre_cond_code_d4){
        this.pre_cond_code_n4 = pre_cond_code_n4;
    }
    public String getPre_cond_code_n4(){
        return pre_cond_code_n4;
    }
    public void setPre_cond_txt_n4(String pre_cond_code_n4){
        this.pre_cond_txt_n4 = pre_cond_txt_n4;
    }

    public String getPre_tmp_min5(){
        return pre_tmp_min5;
    }
    public void setPre_tmp_min5(String pre_tmp_min5){
        this.pre_tmp_min5 = pre_tmp_min5;
    }
    public String getPre_tmp_max5(){
        return pre_tmp_max5;
    }
    public void setPre_tmp_max5(String pre_tmp_max5){
        this.pre_tmp_max5 = pre_tmp_max5;
    }
    public String getPre_date5(){
        return pre_date5;
    }
    public void setPre_date5(String pre_date5){
        this.pre_date5 = pre_date5;
    }
    public String getPre_cond_txt_d5(){
        return pre_cond_txt_d5;
    }
    public void setPre_cond_txt_d5(String pre_cond_txt_d5){
        this.pre_cond_txt_d5 = pre_cond_txt_d5;
    }
    public String getPre_cond_code_d5() {
        return pre_cond_code_d5;
    }
    public void setPre_cond_code_d5(String pre_cond_code_d5){
        this.pre_cond_code_d5 = pre_cond_code_d5;
    }
    public String getPre_cond_txt_n5(){
        return pre_cond_txt_n5;
    }
    public void setPre_cond_code_n5(String pre_cond_code_d5){
        this.pre_cond_code_n5 = pre_cond_code_n5;
    }
    public String getPre_cond_code_n5(){
        return pre_cond_code_n5;
    }
    public void setPre_cond_txt_n5(String pre_cond_code_n5){
        this.pre_cond_txt_n5 = pre_cond_txt_n5;
    }

    public String getPre_tmp_min6(){
        return pre_tmp_min6;
    }
    public void setPre_tmp_min6(String pre_tmp_min6){
        this.pre_tmp_min6 = pre_tmp_min6;
    }
    public String getPre_tmp_max6(){
        return pre_tmp_max6;
    }
    public void setPre_tmp_max6(String pre_tmp_max6){
        this.pre_tmp_max6 = pre_tmp_max6;
    }
    public String getPre_date6(){
        return pre_date6;
    }
    public void setPre_date6(String pre_date6){
        this.pre_date6 = pre_date6;
    }
    public String getPre_cond_txt_d6(){
        return pre_cond_txt_d6;
    }
    public void setPre_cond_txt_d6(String pre_cond_txt_d6){
        this.pre_cond_txt_d6 = pre_cond_txt_d6;
    }
    public String getPre_cond_code_d6() {
        return pre_cond_code_d6;
    }
    public void setPre_cond_code_d6(String pre_cond_code_d6){
        this.pre_cond_code_d6 = pre_cond_code_d6;
    }
    public String getPre_cond_txt_n6(){
        return pre_cond_txt_n6;
    }
    public void setPre_cond_code_n6(String pre_cond_code_d6){
        this.pre_cond_code_n6 = pre_cond_code_n6;
    }
    public String getPre_cond_code_n6(){
        return pre_cond_code_n6;
    }
    public void setPre_cond_txt_n(String pre_cond_code_n){
        this.pre_cond_txt_n6 = pre_cond_txt_n6;
    }
}
