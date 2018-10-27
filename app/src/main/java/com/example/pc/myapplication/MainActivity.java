package com.example.pc.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.example.pc.myapplication.DataBase.DBManager;
import com.example.pc.myapplication.gson.AllCityInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import interfaces.heweather.com.interfacesmodule.bean.Lang;
import interfaces.heweather.com.interfacesmodule.bean.search.Search;
import interfaces.heweather.com.interfacesmodule.view.HeConfig;
import interfaces.heweather.com.interfacesmodule.view.HeWeather;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private final String TAG = "Main";;
    private List<String> data = new ArrayList<String>();
    private GridView gridView;
    private ListAdapter adapter;
    ArrayAdapter<String> adapter1;
    AutoCompleteTextView text;
    public List<AllCityInfo.CityInfo> cityInfos;
    SharedPreferences sharedPreferences;
    DBManager dbManager = new DBManager(MainActivity.this);

    private String city[] = {
            "北京", "上海", "天津", "重庆", "石家庄", "沈阳", "太原", "长春", "哈尔滨", "南京",
            "杭州", "合肥", "福州", "南昌", "济南", "郑州", "武汉", "长沙", "广州", "海口", "成都",
            "贵阳", "昆明", "西安", "兰州", "西宁", "拉萨", "乌鲁木齐", "呼和浩特", "南宁", "银川",
            "香港", "澳门", "台北"
    };
    private String resultCity[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("resultCity", Activity.MODE_PRIVATE);
        text = findViewById(R.id.search_city);
        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.i(TAG, "afterTextChanged: editable=" + editable);
                HeConfig.init("HE1810221021541515", "bca0e8001c5948dc984fbc0110c120a3");
                HeConfig.switchToFreeServerNode();
                if(!editable.toString().equals("") && editable != null){
                    HeWeather.getSearch(MainActivity.this,editable.toString(),"world",30,Lang.CHINESE_SIMPLIFIED,new HeWeather.OnResultSearchBeansListener() {
                        @Override
                        public void onError(Throwable e) {
                            Log.i("Log", "onError: ", e);
                        }

                        @Override
                        public void onSuccess(Search search) {
                            Gson gson = new Gson();
                            Log.i("城市", "onSuccess: "+ gson.toJson(search));
                            String strByJson  = gson.toJson(search).toString();
                            AllCityInfo allCityInfo = new Gson().fromJson(strByJson,AllCityInfo.class);
                            String status = allCityInfo.getStatus();
                            Log.i(TAG, "onSuccess: status=" + status);
                            if(status.trim().equals("ok")){
                                cityInfos = new ArrayList<>();
                                JsonObject jsonObject = new JsonParser().parse(strByJson).getAsJsonObject();
                                JsonArray jsonArray = jsonObject.getAsJsonArray("basic");
                                int num = 0;
                                for (JsonElement  city : jsonArray) {
                                    num++;
                                    //通过反射 得到UserBean.class
                                    AllCityInfo.CityInfo cityInfo = gson.fromJson(city, new TypeToken<AllCityInfo.CityInfo>() {}.getType());
                                    cityInfos.add(cityInfo);
                                }
                                resultCity = new String[num];

                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.clear();
                                for(int i = 0; i < num; i++){
                                    String parent_city = cityInfos.get(i).getParent_city();
                                    String location = cityInfos.get(i).getLocation();
                                    resultCity[i] = location + "，" + parent_city;
                                    Log.i(TAG, "onSuccess: resultCity=" + resultCity[i]);
                                    String ss = "resultCity" + i;
                                    String scid = "cid" + i;
                                    editor.putString(ss, resultCity[i]);
                                    editor.putString(scid, cityInfos.get(i).getCid());
                                }
                                editor.putInt("num", num).commit();
                                Intent countCounter = new Intent(MainActivity.this, ResultCityShowActivity.class);
                                startActivityForResult(countCounter, 1);
                                /*adapter1 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, resultCity);
                                text.setAdapter(adapter1);
                                text.setThreshold(1);*/
                            }
                        }
                    });
                }
            }
        });

        gridView = findViewById(R.id.recommendedCity);
        //init data
        for(int i = 0; i < 34; i++){
            data.add(city[i]);
        }

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i(TAG, "Onclick: parent=" + parent);
        Log.i(TAG, "Onclick: view=" + view);
        Log.i(TAG, "Onclick: position=" + position);
        Log.i(TAG, "Onclick: id=" + id);
        Log.i(TAG, "onItemClick: city=" + data.get(position));
        text.setText(data.get(position));
        //获取sharedPreferences对象
        /*SharedPreferences sharedPreferences = getSharedPreferences("select_city", Activity.MODE_PRIVATE);
        //获取editor对象
        SharedPreferences.Editor editor = sharedPreferences.edit();     //获取编辑器
        editor.putString("name",  data.get(position));*/

        //转到另一个页面
    }
}



/*HeWeather.getSearch(MainActivity.this,"wenjiang","world",10,Lang.CHINESE_SIMPLIFIED,new HeWeather.OnResultSearchBeansListener(){
                    @Override
                    public void onError(Throwable e) {
                        Log.i("Log", "onError: ", e);
                    }

                    @Override
                    public void onSuccess(Search search) {
                        Log.i("城市", "onSuccess: "+ new Gson().toJson(search));

                    }
                });

                //Log.i(TAG, "afterTextChanged: dbManager.findByCity_CN(editable.toString()).getCity_ID()="
                    //+dbManager.findByCity_CN(editable.toString()).gewtCity_ID());

                /*HeConfig.init("HE1810221021541515", "bca0e8001c5948dc984fbc0110c120a3");
                HeConfig.switchToFreeServerNode();
                HeWeather.getWeatherNow(MainActivity.this, "CN101010100", Lang.CHINESE_SIMPLIFIED, Unit.METRIC,
                        new HeWeather.OnResultWeatherNowBeanListener() {
                            @Override
                            public void onError(Throwable e) {
                                Log.i("Log", "onError: ", e);
                            }

                            @Override
                            public void onSuccess(List dataObject) {
                                Log.i("Log", "onSuccess: " + new Gson().toJson(dataObject));
                            }
                        });
                        */


                        /*JsonObject jsonObject = new JsonParser().parse(strByJson ).getAsJsonObject();
                        JsonArray jsonArray = jsonObject.getAsJsonArray("basic");
                        ArrayList<BasicInfo> userBeanList = new ArrayList<>();
                        for (JsonElement user : jsonArray) {
                            //通过反射 得到UserBean.class
                            BasicInfo cityInfo = gson.fromJson(user, new TypeToken<BasicInfo>() {}.getType());
                            userBeanList.add(cityInfo);
                        }*/

//List<HashMap<String, String>> cityInfoStr = gson.fromJson(gson.toJson(search), new TypeToken<List<HashMap<String, String>>>(){}.getType())



