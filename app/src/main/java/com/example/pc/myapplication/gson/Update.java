package com.example.pc.myapplication.gson;

/**
 * Created by pc on 2018/10/26.
 */

public class Update {

    private String loc;
    private String utc;

    public Update(){
        super();
    }

    public Update(String loc, String utc){
        super();
        this.loc = loc;
        this.utc = utc;
    }

    public String getLoc(){
        return loc;
    }
    public void setLoc(String loc){
        this.loc = loc;
    }
    public String getUtc(){
        return utc;
    }
    public void setUtc(String utc){
        this.utc = utc;
    }
}
