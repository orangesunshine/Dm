package com.orange.mvp.contract

interface IDmContract {
    interface View{
        fun showMsg(msg:String)
    }

    interface Presenter{
        fun attach(v:View)

        fun getMsg():String
    }
}