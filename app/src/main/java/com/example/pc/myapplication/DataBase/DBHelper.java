package com.example.pc.myapplication.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by pc on 2018/10/24.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "cityOfChina.db";
    public static final String TB_NAME = "MyCity";
    public static final String TB_NAME1 = "WeatherNow";
    public static final String TB_NAME2 = "AirConditionNow";
    public static final String TB_NAME3 = "WeatherHourly";
    public static final String TB_NAME4 = "WeatherForecast";
    public static final String TB_NAME5 = "Lifestyle";

    private String SqlCreateMyCity = "CREATE TABLE "+TB_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,City_ID TEXT,City_EN TEXT," +
            "City_CN TEXT, Country_code TEXT, Country_EN TEXT, Country_CN TEXT, Province_EN TEXT, Province_CN TEXT," +
            " Admin_district_EN TEXT, Admin_district_CN TEXT, Latitude TEXT, Longitude TEXT, AD_code TEXT)";

    private String SqlCreateWeatherNow = "CREATE TABLE " + TB_NAME1 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, cid TEXT, condCode TEXT," +
            " condTxt TEXT, tmp, hum TEXT, fl TEXT, windDir TEXT, windSc TEXT, windSpd TEXT, loc TEXT)";

    private String SqlCreateAirConditionNow = "CREATE TABLE " + TB_NAME2 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, cid TEXT, aqi TEXT," +
            " main TEXT, pm10 TEXT, pm25 TEXT, no2 TEXT, o3 TEXT, co TEXT)";

    private String SqlCreateWeatherHourly = "CREATE TABLE " + TB_NAME3 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, cid TEXT, time TEXT," +
            " tmp TEXT, condTxt TEXT, condCode TEXT)";

    private String SqlCreateWeatherForecast = "CREATE TABLE " + TB_NAME4 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, cid TEXT, date TEXT," +
            " tmpMin TEXT, tmpMax TEXT, condCodeD TEXT, condTxtD TEXT, condCodeN TEXT, condTxtN TEXT, sr TEXT, ss TEXT)";

    private String SqlCreateLifestyle = "CREATE TABLE " + TB_NAME5 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, cid TEXT, brf TEXT, txt TEXT, type TEXT)";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(Context context) {
        super(context,DB_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SqlCreateMyCity);
        if(sqLiteDatabase.query(TB_NAME,null, null, null, null,
                null, null, null).getCount() == 0){
            try {
                File csv = new File(Environment.getExternalStorageDirectory() + "E:\\china-city-list.csv"); // CSV文件路径
                BufferedReader br = new BufferedReader(new FileReader(csv));
                br.readLine();
                String line = "";
                //这里读取csv文件
                int i = 1;
                while ((line = br.readLine()) != null) {
                    /**
                     *  csv格式每一列内容以逗号分隔,因此要取出想要的内容,以逗号为分割符分割字符串即可,
                     *  把分割结果存到到数组中,根据数组来取得相应值
                     */
                    String buffer[] = line.split(",");// 以逗号分隔
                    sqLiteDatabase.execSQL("insert into stu_table(id,City_ID,City_EN,City_CN,Country_code,Country_EN,Country_CN," +
                            "Province_EN,Province_CN,Admin_district_EN,Admin_district_CN,Latitude,Longitude,AD_code)" +
                            " values("+i+","+buffer[1]+","+buffer[2]+","+buffer[3]+","+buffer[4]+","+buffer[5]+","+buffer[6]+","
                            +buffer[7]+","+buffer[8]+","+buffer[9]+","+buffer[10]+","+buffer[11]+","+buffer[12]+","+buffer[13]+")");
                    i++;
                }
                sqLiteDatabase.execSQL(SqlCreateWeatherNow);
                sqLiteDatabase.execSQL(SqlCreateAirConditionNow);
                sqLiteDatabase.execSQL(SqlCreateWeatherHourly);
                sqLiteDatabase.execSQL(SqlCreateWeatherForecast);
                sqLiteDatabase.execSQL(SqlCreateLifestyle);
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
