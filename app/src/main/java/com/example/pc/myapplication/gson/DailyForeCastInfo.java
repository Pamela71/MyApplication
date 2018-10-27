package com.example.pc.myapplication.gson;

import java.util.List;

/**
 * Created by pc on 2018/10/27.
 */

public class DailyForeCastInfo {

    private List<Daily_forecast> daily_forecast;
    private Basic basic;
    private String status;
    private Update update;

    public void setDaily_forecast(List<Daily_forecast> daily_forecast) {
        this.daily_forecast = daily_forecast;
    }
    public List<Daily_forecast> getDaily_forecast() {
        return daily_forecast;
    }

    public void setBasic(Basic basic) {
        this.basic = basic;
    }
    public Basic getBasic() {
        return basic;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    public void setUpdate(Update update) {
        this.update = update;
    }
    public Update getUpdate() {
        return update;
    }

}
