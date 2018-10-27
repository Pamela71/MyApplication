package com.example.pc.myapplication.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pc.myapplication.gson.BeanAir;
import com.example.pc.myapplication.gson.BeanForecast;
import com.example.pc.myapplication.gson.BeanLifestyle;
import com.example.pc.myapplication.gson.BeanHour;
import com.example.pc.myapplication.gson.BeanNow;

import java.util.List;

/**
 * Created by pc on 2018/10/24.
 */

public class DBManager {

    private DBHelper dbHelper;
    private String TBNAME;
    private String TBNAME1;
    private String TBNAME2;
    private String TBNAME3;
    private String TBNAME4;
    private String TBNAME5;

    public DBManager(Context context) {
        dbHelper = new DBHelper(context);
        TBNAME = DBHelper.TB_NAME;
        TBNAME1 = DBHelper.TB_NAME1;
        TBNAME2 = DBHelper.TB_NAME2;
        TBNAME3 = DBHelper.TB_NAME3;
        TBNAME4 = DBHelper.TB_NAME4;
        TBNAME5 = DBHelper.TB_NAME5;
    }

    public void addWeatherNow(BeanNow item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        BeanNow.Now now = item.getNow();
        values.put("cid", item.getBasic().getCid());
        values.put("condCode", now.getCondCode());
        values.put("condTxt", now.getCondTxt());
        values.put("tmp",now.getTmp());
        values.put("hum", now.getHum());
        values.put("fl", now.getFl());
        values.put("windDir", now.getWindDir());
        values.put("windSc",now.getWindSc());
        values.put("windSpd", now.getWindSpd());
        values.put("loc", item.getUpdate().getLoc());

        db.insert(TBNAME1, null, values);
        db.close();
    }

    public void addAirConditionNow(BeanAir item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        BeanAir.AirNowCity air = item.getAirNowCity();
        values.put("cid", item.getBasic().getCid());
        values.put("aqi", air.getAqi());
        values.put("main",air.getMain());
        values.put("pm10", air.getPm10());
        values.put("pm25", air.getPm25());
        values.put("no2",air.getNo2());
        values.put("o3", air.getO3());
        values.put("co", air.getCo());

        db.insert(TBNAME2, null, values);
        db.close();
    }

    public void addWeatherHourly(BeanHour item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        List<BeanHour.Hourly> hourly = item.getHourly();
        int size = hourly.size();
        for(int i = 0; i < size; i++){
            values.put("cid", item.getBasic().getCid());
            values.put("time", hourly.get(i).getTime());
            values.put("tmp",hourly.get(i).getTmp());
            values.put("condTxt", hourly.get(i).getCondTxt());
            values.put("condCode", hourly.get(i).getCondCode());
            db.insert(TBNAME3, null, values);
        }

        db.close();
    }

    public void addWeatherForecast(BeanForecast item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        List<BeanForecast.DailyForecast> dailyForecast = item.getDailyForecast();
        for(int i = 0; i < 7; i++){
            values.put("cid", item.getBasic().getCid());
            values.put("date", dailyForecast.get(i).getDate());
            values.put("tmpMin",dailyForecast.get(i).getTmpMin());
            values.put("tmpMax", dailyForecast.get(i).getTmpMax());
            values.put("condCodeD", dailyForecast.get(i).getCondCodeD());
            values.put("condTxtD", dailyForecast.get(i).getCondTxtD());
            values.put("condCodeN", dailyForecast.get(i).getCondCodeN());
            values.put("condTxtN", dailyForecast.get(i).getCondTxtN());
            values.put("sr", dailyForecast.get(i).getSr());
            values.put("ss", dailyForecast.get(i).getSs());
            db.insert(TBNAME4, null, values);
        }

        db.close();
    }

    public void addLifestyle(BeanLifestyle item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        List<BeanLifestyle.Lifestyle> lifestyle = item.getLifestyle();
        for(int i = 0; i < 8; i++){
            values.put("cid", item.getBasic().getCid());
            values.put("brf", lifestyle.get(i).getBrf());
            values.put("txt",lifestyle.get(i).getTxt());
            values.put("type", lifestyle.get(i).getTxt());
            db.insert(TBNAME5, null, values);
        }

        db.close();
    }
















    public void addCity(CityItem item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("City_ID", item.getCity_ID());
        values.put("City_EN", item.getCity_EN());
        values.put("City_CN", item.getCity_CN());
        values.put("Country_code", item.getCountry_code());
        values.put("Country_EN", item.getCountry_EN());
        values.put("Country_CN", item.getCountry_CN());
        values.put("Province_EN", item.getProvince_EN());
        values.put("Province_CN", item.getCountry_CN());
        values.put("Admin_district_EN", item.getAdmin_district_EN());
        values.put("Admin_district_CN", item.getAdmin_district_CN());
        values.put("Latitude", item.getLatitude());
        values.put("Longitude", item.getLongitude());
        values.put("AD_code", item.getAD_code());

        db.insert(TBNAME, null, values);
        db.close();
    }

    public CityItem findById(int id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME, null, "ID=?", new String[]{String.valueOf(id)}, null, null, null);
        CityItem cityItem = null;
        if(cursor!=null && cursor.moveToFirst()){
            cityItem = new CityItem();
            cityItem.setId(cursor.getInt(cursor.getColumnIndex("ID")));
            cityItem.setCity_ID(cursor.getString(cursor.getColumnIndex("City_ID")));
            cityItem.setCity_EN(cursor.getString(cursor.getColumnIndex("City_EN")));
            cityItem.setCity_CN(cursor.getString(cursor.getColumnIndex("City_CN")));
            cityItem.setCountry_code(cursor.getString(cursor.getColumnIndex("Country_code")));
            cityItem.setCountry_EN(cursor.getString(cursor.getColumnIndex("Country_EN")));
            cityItem.setCountry_CN(cursor.getString(cursor.getColumnIndex("Country_CN")));
            cityItem.setProvince_EN(cursor.getString(cursor.getColumnIndex("Province_EN")));
            cityItem.setProvince_CN(cursor.getString(cursor.getColumnIndex("Province_CN")));
            cityItem.setAdmin_district_EN(cursor.getString(cursor.getColumnIndex("Admin_district_EN")));
            cityItem.setAdmin_district_CN(cursor.getString(cursor.getColumnIndex("Admin_district_CN")));
            cityItem.setLatitude(cursor.getString(cursor.getColumnIndex("Latitude")));
            cityItem.setLongitude(cursor.getString(cursor.getColumnIndex("Longitude")));
            cityItem.setAD_code(cursor.getString(cursor.getColumnIndex("AD_code")));
            cursor.close();
        }
        db.close();
        return cityItem;
    }

    public CityItem findByCity_CN(String City_CN){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME, null, "City_CN=?", new String[]{City_CN}, null, null, null);
        CityItem cityItem = null;
        if(cursor!=null && cursor.moveToFirst()){
            cityItem = new CityItem();
            cityItem.setId(cursor.getInt(cursor.getColumnIndex("ID")));
            cityItem.setCity_ID(cursor.getString(cursor.getColumnIndex("City_ID")));
            cityItem.setCity_EN(cursor.getString(cursor.getColumnIndex("City_EN")));
            cityItem.setCity_CN(cursor.getString(cursor.getColumnIndex("City_CN")));
            cityItem.setCountry_code(cursor.getString(cursor.getColumnIndex("Country_code")));
            cityItem.setCountry_EN(cursor.getString(cursor.getColumnIndex("Country_EN")));
            cityItem.setCountry_CN(cursor.getString(cursor.getColumnIndex("Country_CN")));
            cityItem.setProvince_EN(cursor.getString(cursor.getColumnIndex("Province_EN")));
            cityItem.setProvince_CN(cursor.getString(cursor.getColumnIndex("Province_CN")));
            cityItem.setAdmin_district_EN(cursor.getString(cursor.getColumnIndex("Admin_district_EN")));
            cityItem.setAdmin_district_CN(cursor.getString(cursor.getColumnIndex("Admin_district_CN")));
            cityItem.setLatitude(cursor.getString(cursor.getColumnIndex("Latitude")));
            cityItem.setLongitude(cursor.getString(cursor.getColumnIndex("Longitude")));
            cityItem.setAD_code(cursor.getString(cursor.getColumnIndex("AD_code")));
            cursor.close();
        }
        db.close();
        return cityItem;
    }

    public void deleteAll(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME,null,null);
        db.close();
    }
}
