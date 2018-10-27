package com.example.pc.myapplication.gson;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;
import interfaces.heweather.com.interfacesmodule.bean.Lang;
import interfaces.heweather.com.interfacesmodule.bean.Unit;
import interfaces.heweather.com.interfacesmodule.bean.air.now.AirNow;
import interfaces.heweather.com.interfacesmodule.bean.search.Search;
import interfaces.heweather.com.interfacesmodule.bean.weather.forecast.Forecast;
import interfaces.heweather.com.interfacesmodule.view.HeConfig;
import interfaces.heweather.com.interfacesmodule.view.HeWeather;

public class GetData {

    interfaces.heweather.com.interfacesmodule.view.HeWeather HeWeather  = new HeWeather();
    //通过构造函数来获取

    Gson gson = new Gson();
    //通过 GsonBuilder 来获取，可以进行多项特殊配置
    //Gson gson = new GsonBuilder().create();
    public void GetData(final Context context,String location){

        HeConfig.init("HE1810211323041610","ad11ae24575d46e7b5614986a9ae5111");
        HeConfig.switchToFreeServerNode();

        HeWeather.getWeatherNow(context, "CN101010100", Lang.CHINESE_SIMPLIFIED, Unit.METRIC,
                new HeWeather.OnResultWeatherNowBeanListener() {
                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onSuccess(List dataObject) {
                        String data = gson.toJson(dataObject);
                        data = data.substring(1,data.length()-1);

                        Log.i("Now", "onSuccess: "+data);

                        BeanNow now = gson.fromJson(data,BeanNow.class);
                        Log.i("gson", "onSuccess: "+now.getNow().getTmp());
                       }
                });

        HeWeather.getWeatherHourly(context,"CN101010100", new HeWeather.OnResultWeatherHourlyBeanListener(){
            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onSuccess(List dataObject) {
                String data = gson.toJson(dataObject);
                data = data.substring(1,data.length()-1);
                //Log.i("Hour", "onSuccess: " + data);
                BeanHour hour = gson.fromJson(data,BeanHour.class);
                Log.i("Hour", "onSuccess: " + hour.getUpdate().getLoc());
            }
        });

        HeWeather.getWeatherForecast(context,"CN101010100", new HeWeather.OnResultWeatherForecastBeanListener (){
            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onSuccess(List<Forecast> list) {
                String data = gson.toJson(list);
                data = data.substring(1,data.length()-1);
                //Log.i("Forecast", "onSuccess: " + data);
                BeanForecast forecast = gson.fromJson(data,BeanForecast.class);
                Log.i("Forecast", "onSuccess: "+forecast.getDailyForecast().get(0));

            }
        });

        HeWeather.getAirNow(context,"CN101010100", new HeWeather.OnResultAirNowBeansListener  (){
                    @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onSuccess(List<AirNow> list) {
                String data = gson.toJson(list);
                data = data.substring(1,data.length()-1);
                Log.i("Airnow", "onSuccess: " + data);
                BeanAir air = gson.fromJson(data,BeanAir.class);
                Log.i("Air", "onSuccess: "+air.getBasic().getLon());
            }
        });

        HeWeather.getSearch(context,"重庆","world",30,Lang.CHINESE_SIMPLIFIED,new HeWeather.OnResultSearchBeansListener(){
            @Override
            public void onError(Throwable e) {
                Log.i("Log", "onError: ", e);
                //查不到略略略
            }

            @Override
            public void onSuccess(Search search) {
                Log.i("城市", "onSuccess: "+ gson.toJson(search));
            }
        });
    }
}
