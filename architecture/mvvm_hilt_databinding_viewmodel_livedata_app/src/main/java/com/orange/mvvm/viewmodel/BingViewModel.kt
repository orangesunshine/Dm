package com.orange.mvvm.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.orange.mvvm.data.ImageBean
import com.orange.mvvm.repository.BingRepository
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class BingViewModel @ViewModelInject constructor(
    private var repository: BingRepository/*, @Assisted private val savedState: SavedStateHandle*/
) : ViewModel() {

    private var imageMld: MutableLiveData<ImageBean> = MutableLiveData()
    private var imageLd: LiveData<ImageBean> = imageMld
    fun getImage(): LiveData<ImageBean> {
        return imageLd
    }

    fun getBingImage(format: String, idx: Int, n: Int) {
        var observer = object : Observer<ImageBean> {
            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
            }

            override fun onNext(t: ImageBean) {
                println("younger--onNext: ${t}")
                imageMld.value = t
            }

            override fun onError(e: Throwable) {
            }

            override fun onComplete() {
            }


        }
        repository?.let {
            it.getBingImage(format, idx, n)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
        }
    }
}