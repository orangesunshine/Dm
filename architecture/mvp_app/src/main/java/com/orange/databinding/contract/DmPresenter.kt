package com.orange.mvp.contract

import com.orange.mvp.datasource.IDataSource

class DmPresenter constructor(var dataSource:IDataSource):IDmContract.Presenter{
    lateinit var view:IDmContract.View


    override fun attach(v: IDmContract.View) {
        view = v
    }

    override fun getMsg():String {
        return dataSource.getMsg()
    }
}