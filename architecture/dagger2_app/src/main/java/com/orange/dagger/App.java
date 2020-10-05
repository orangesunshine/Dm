package com.orange.dagger;

import android.app.Application;

import com.orange.dagger.component.AppComponent;

/**
 * @Description:
 * @Author: orange
 * @Date: 2020/9/28 8:48 PM
 */
public class App extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        //appComponent = DaggerAppComponent.create();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
