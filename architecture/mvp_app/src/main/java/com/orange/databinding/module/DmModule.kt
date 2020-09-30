package com.orange.mvp.module

import com.orange.mvp.datasource.DataSource
import com.orange.mvp.datasource.IDataSource
import dagger.Module
import dagger.Provides

@Module
class DmModule {

    @Provides
    fun provides():IDataSource{
        return DataSource()
    }
}