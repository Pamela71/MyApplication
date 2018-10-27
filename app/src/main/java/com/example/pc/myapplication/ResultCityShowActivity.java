package com.example.pc.myapplication;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.example.pc.myapplication.gson.BeanNow;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import interfaces.heweather.com.interfacesmodule.bean.Lang;
import interfaces.heweather.com.interfacesmodule.bean.Unit;
import interfaces.heweather.com.interfacesmodule.view.HeConfig;
import interfaces.heweather.com.interfacesmodule.view.HeWeather;

public class ResultCityShowActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private GridView gridView;
    private ListAdapter adapter;
    private List<String> cities = new ArrayList<String>();
    private List<String> cityCids = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_city_show);

        gridView = findViewById(R.id.show_city);
        SharedPreferences sharedPreferences = getSharedPreferences("resultCity", Activity.MODE_PRIVATE);
        int num = sharedPreferences.getInt("num", 1);
        for (int i = 0; i < num; i++){
            String ss = "resultCity" + i;
            String scid = "cid" + i;
            cities.add(sharedPreferences.getString(ss, ""));
            cityCids.add(sharedPreferences.getString(scid, ""));
        }
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cities);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        HeConfig.init("HE1810211323041610", "ad11ae24575d46e7b5614986a9ae5111");
        HeConfig.switchToFreeServerNode();
        HeWeather.getWeatherNow(this, cityCids.get(position), Lang.CHINESE_SIMPLIFIED, Unit.METRIC,
                new HeWeather.OnResultWeatherNowBeanListener() {
                    @Override
                    public void onError(Throwable e) {
                        Log.i("Log", "onError: ", e);
                    }

                    @Override
                    public void onSuccess(List dataObject) {
                        Gson gson = new Gson();
                        Log.i("Log", "onSuccess: " + gson.toJson(dataObject));
                        String data = gson.toJson(dataObject);
                        data = data.substring(1,data.length()-1);

                        Log.i("Now", "onSuccess: "+data);

                        BeanNow now = gson.fromJson(data,BeanNow.class);
                        Log.i("gson", "onSuccess: "+now.getNow().getTmp());
                    }
                });
    }
}
