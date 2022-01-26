package com.mayunfeng.road;

import com.pikachu.utils.utils.SharedPreferencesUtils;

/**
 * @ProjectName: 一带一路
 * @Package: com.mayunfeng.road
 * @Author: pkpk.run
 * @Description: null
 */
public class Application extends android.app.Application {

    public static String APP_IP = "192.168.0.1";
    public static String APP_PORT = "8888";




    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferencesUtils.init(this);



    }





}
