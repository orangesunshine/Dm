package com.orange.mvp.datasource

import android.os.SystemClock

class DataSource:IDataSource{
    override fun getMsg():String{
        SystemClock.sleep(500)
        return "DataSource Msg after wait 500 mills"
    }
}