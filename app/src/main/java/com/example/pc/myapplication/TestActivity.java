package com.example.pc.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.pc.myapplication.DataBase.CityItem;
import com.example.pc.myapplication.DataBase.DBManager;
import com.example.pc.myapplication.gson.BeanLifestyle;
import com.example.pc.myapplication.DataBase.WeatherItem;
import com.example.pc.myapplication.gson.DailyForeCastInfo;
import com.example.pc.myapplication.gson.Daily_forecast;
import com.example.pc.myapplication.gson.NowWeatherInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import interfaces.heweather.com.interfacesmodule.bean.Lang;
import interfaces.heweather.com.interfacesmodule.bean.Unit;
import interfaces.heweather.com.interfacesmodule.bean.weather.forecast.Forecast;
import interfaces.heweather.com.interfacesmodule.bean.weather.lifestyle.Lifestyle;
import interfaces.heweather.com.interfacesmodule.view.HeConfig;
import interfaces.heweather.com.interfacesmodule.view.HeWeather;

public class TestActivity extends AppCompatActivity {

    DBManager dbManager = new DBManager(this);
    private Button btn;
    private CityItem city;
    private String TAG = "TestActivity";
    private List<NowWeatherInfo.WeatherInfo> weatherInfos;
    private List<NowWeatherInfo.UpdateMsg> updateMsgs;
    WeatherItem nowWeatherItem = new WeatherItem();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

    }

    public void MyTest(View view){

        HeConfig.init("HE1810211323041610","ad11ae24575d46e7b5614986a9ae5111");
        HeConfig.switchToFreeServerNode();
        HeWeather.getWeatherNow(TestActivity.this, "CN101010100", Lang.CHINESE_SIMPLIFIED, Unit.METRIC,
                new HeWeather.OnResultWeatherNowBeanListener() {
                    @Override
                    public void onError(Throwable e) {
                        Log.i("Log", "HeWeather.getWeatherNow.onError: ", e);
                    }

                    @Override
                    public void onSuccess(List dataObject) {
                        Gson gson = new Gson();
                        Log.i("Log", "HeWeather.getWeatherNow.onSuccess: " + gson.toJson(dataObject));

                        String strByJson  = gson.toJson(dataObject).toString();
                        strByJson = strByJson.substring(1, strByJson.length()-1);

                        NowWeatherInfo nowWeatherInfo = gson.fromJson(strByJson,NowWeatherInfo.class);
                        String status = nowWeatherInfo.getStatus();
                        if(status.equals("ok")){
                            nowWeatherItem.setStatus(status);
                            JsonObject jsonObject = new JsonParser().parse(strByJson).getAsJsonObject();
                            Log.i(TAG, "HeWeather.getWeatherNow.onSuccess: jsonObject.get(\"now\").getAsString()=" + jsonObject.getAsJsonObject("now").toString());
                            JsonObject jsonObjectNow = jsonObject.getAsJsonObject("now");
                            JsonObject jsonObjectBasic = jsonObject.getAsJsonObject("basic");
                            // cond_code, cond_txt, fl, hum, tmp;天气状况代码， 天气状况， 体感温度， 相对湿度， 温度
                            // wind_dir, wind_sc,wind_spd;风向, 风力, 风速，公里/小时
                            // utc, cid, location;世界时间， 地区代码， 地区

                            nowWeatherItem.setCond_code(jsonObjectNow.get("cond_code").toString());
                            nowWeatherItem.setCond_txt(jsonObjectNow.get("cond_txt").toString());
                            nowWeatherItem.setFl(jsonObjectNow.get("fl").toString());
                            nowWeatherItem.setHum(jsonObjectNow.get("hum").toString());
                            nowWeatherItem.setTmp(jsonObjectNow.get("tmp").toString());
                            nowWeatherItem.setWind_dir(jsonObjectNow.get("wind_dir").toString());
                            nowWeatherItem.setWind_sc(jsonObjectNow.get("wind_sc").toString());
                            nowWeatherItem.setWind_spd(jsonObjectNow.get("wind_spd").toString());
                            nowWeatherItem.setUtc(jsonObject.getAsJsonObject("update").get("utc").toString());
                            nowWeatherItem.setCid(jsonObjectBasic.get("cid").toString());
                            nowWeatherItem.setLocation(jsonObjectBasic.get("location").toString());

                            Log.i(TAG, "onSuccess: 完美收工！");
                        }
                    }
                });
        HeWeather.getWeatherForecast(TestActivity.this, "CN101010300", Lang.CHINESE_SIMPLIFIED, Unit.METRIC,
                new HeWeather.OnResultWeatherForecastBeanListener(){

                    @Override
                    public void onError(Throwable e) {
                        Log.i("Log", "HeWeather.getWeatherForecast.onError: ", e);
                    }

                    @Override
                    public void onSuccess(List<Forecast> list) {
                        Gson gson = new Gson();
                        Log.i("Log", "HeWeather.getWeatherForecast.onSuccess: " + gson.toJson(list));
                        String strByJson  = gson.toJson(list).toString();
                        strByJson = strByJson.substring(1, strByJson.length()-1);
                        DailyForeCastInfo dailyForeCastInfo = gson.fromJson(strByJson,DailyForeCastInfo.class);
                        String status = dailyForeCastInfo.getStatus();
                        if(status.equals("ok")){
                            JsonObject jsonObject = new JsonParser().parse(strByJson).getAsJsonObject();
                            JsonArray jsonArray = jsonObject.getAsJsonArray("daily_forecast");
                            int i = 0;
                            String pre_tmp_min[] = new String[7];
                            String pre_tmp_max[] = new String[7];
                            String pre_date[] = new String[7];
                            String pre_cond_txt_d[] = new String[7];
                            String pre_cond_code_d[] = new String[7];
                            String pre_cond_code_n[] = new String[7];
                            String pre_cond_txt_n[] = new String[7];
                            for (JsonElement condition : jsonArray) {
                                Daily_forecast daily_forecast = gson.fromJson(condition, new TypeToken<Daily_forecast>() {}.getType());
                                pre_tmp_min[i] = daily_forecast.getTmp_min();
                                pre_tmp_max[i] = daily_forecast.getTmp_max();
                                pre_date[i] = daily_forecast.getDate().toString();
                                pre_cond_txt_d[i] = daily_forecast.getCond_txt_d();
                                pre_cond_code_d[i] = daily_forecast.getCond_code_d();
                                pre_cond_code_n[i] = daily_forecast.getCond_code_n();
                                pre_cond_txt_n[i] = daily_forecast.getCond_txt_n();
                            }
                            nowWeatherItem.setPre_tmp_min0(pre_tmp_min[0]);
                            nowWeatherItem.setPre_tmp_min1(pre_tmp_min[1]);
                            nowWeatherItem.setPre_tmp_min2(pre_tmp_min[2]);
                            nowWeatherItem.setPre_tmp_min3(pre_tmp_min[3]);
                            nowWeatherItem.setPre_tmp_min4(pre_tmp_min[4]);
                            nowWeatherItem.setPre_tmp_min5(pre_tmp_min[5]);
                            nowWeatherItem.setPre_tmp_min6(pre_tmp_min[6]);

                            nowWeatherItem.setPre_tmp_max0(pre_tmp_max[0]);
                            nowWeatherItem.setPre_tmp_max1(pre_tmp_max[1]);
                            nowWeatherItem.setPre_tmp_max2(pre_tmp_max[2]);
                            nowWeatherItem.setPre_tmp_max3(pre_tmp_max[3]);
                            nowWeatherItem.setPre_tmp_max4(pre_tmp_max[4]);
                            nowWeatherItem.setPre_tmp_max5(pre_tmp_max[5]);
                            nowWeatherItem.setPre_tmp_max6(pre_tmp_max[6]);

                            nowWeatherItem.setPre_date0(pre_date[0]);
                            nowWeatherItem.setPre_date1(pre_date[1]);
                            nowWeatherItem.setPre_date2(pre_date[2]);
                            nowWeatherItem.setPre_date3(pre_date[3]);
                            nowWeatherItem.setPre_date4(pre_date[4]);
                            nowWeatherItem.setPre_date5(pre_date[5]);
                            nowWeatherItem.setPre_date6(pre_date[6]);

                            nowWeatherItem.setPre_cond_txt_d0(pre_cond_txt_d[0]);
                            nowWeatherItem.setPre_cond_txt_d1(pre_cond_txt_d[1]);
                            nowWeatherItem.setPre_cond_txt_d2(pre_cond_txt_d[2]);
                            nowWeatherItem.setPre_cond_txt_d3(pre_cond_txt_d[3]);
                            nowWeatherItem.setPre_cond_txt_d4(pre_cond_txt_d[4]);
                            nowWeatherItem.setPre_cond_txt_d5(pre_cond_txt_d[5]);
                            nowWeatherItem.setPre_cond_txt_d6(pre_cond_txt_d[6]);

                            nowWeatherItem.setPre_cond_code_d0(pre_cond_code_d[0]);
                            nowWeatherItem.setPre_cond_code_d1(pre_cond_code_d[1]);
                            nowWeatherItem.setPre_cond_code_d2(pre_cond_code_d[2]);
                            nowWeatherItem.setPre_cond_code_d3(pre_cond_code_d[3]);
                            nowWeatherItem.setPre_cond_code_d4(pre_cond_code_d[4]);
                            nowWeatherItem.setPre_cond_code_d5(pre_cond_code_d[5]);
                            nowWeatherItem.setPre_cond_code_d6(pre_cond_code_d[6]);


                            nowWeatherItem.setPre_cond_txt_d0(pre_cond_txt_d[0]);
                            nowWeatherItem.setPre_cond_txt_d1(pre_cond_txt_d[1]);
                            nowWeatherItem.setPre_cond_txt_d2(pre_cond_txt_d[2]);
                            nowWeatherItem.setPre_cond_txt_d3(pre_cond_txt_d[3]);
                            nowWeatherItem.setPre_cond_txt_d4(pre_cond_txt_d[4]);
                            nowWeatherItem.setPre_cond_txt_d5(pre_cond_txt_d[5]);
                            nowWeatherItem.setPre_cond_txt_d6(pre_cond_txt_d[6]);

                            nowWeatherItem.setPre_cond_code_n0(pre_cond_code_n[0]);
                            nowWeatherItem.setPre_cond_code_n1(pre_cond_code_n[1]);
                            nowWeatherItem.setPre_cond_code_n2(pre_cond_code_n[2]);
                            nowWeatherItem.setPre_cond_code_n3(pre_cond_code_n[3]);
                            nowWeatherItem.setPre_cond_code_n4(pre_cond_code_n[4]);
                            nowWeatherItem.setPre_cond_code_n5(pre_cond_code_n[5]);
                            nowWeatherItem.setPre_cond_code_n6(pre_cond_code_n[6]);
                        }
                    }
                });

        HeWeather.getWeatherLifeStyle(TestActivity.this,"CN101010100", new HeWeather.OnResultWeatherLifeStyleBeanListener() {
            @Override
            public void onError(Throwable throwable) {
                Log.i("WeatherLifeStyle", "onError: ", throwable);
            }

            @Override
            public void onSuccess(List<Lifestyle> list) {
                Gson gson = new Gson();
                Log.i("WeatherLifeStyle", "onSuccess: "+ gson.toJson(list));
                String data = gson.toJson(list);
                data = data.substring(1,data.length()-1);
                Log.i("WeatherLifeStyle", "onSuccess: " + data);
                BeanLifestyle air = gson.fromJson(data,BeanLifestyle.class);
                Log.i("WeatherLifeStyle", "onSuccess: "+ air.getLifestyle().get(0).getType());
            }
        });



        /*getWeatherForecast(TestActivity.this,"CN101010100", new HeWeather.OnResultWeatherForecastBeanListener (){
            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onSuccess(List<Forecast> list) {
                Gson gson = new Gson();
                String data = gson.toJson(list);
                data = data.substring(1,data.length()-1);
                //Log.i("Forecast", "onSuccess: " + data);
                BeanForecast forecast = gson.fromJson(data,BeanForecast.class);
                Log.i("Forecast", "onSuccess: "+forecast.getDailyForecast().get(0));

            }
        });**/

        //dbManager.addWeatherCondition(nowWeatherItem);
    }
}

