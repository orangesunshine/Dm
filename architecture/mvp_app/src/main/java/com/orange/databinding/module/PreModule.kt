package com.orange.mvp.module

import com.orange.mvp.contract.DmPresenter
import com.orange.mvp.contract.IDmContract
import com.orange.mvp.datasource.IDataSource
import dagger.Module
import dagger.Provides

@Module
class PreModule{
    @Provides
    fun providePresent(dataSource: IDataSource):IDmContract.Presenter{
        return DmPresenter(dataSource)
    }
}