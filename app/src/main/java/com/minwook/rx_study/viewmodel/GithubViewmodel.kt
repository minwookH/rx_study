package com.minwook.rx_study.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.minwook.rx_study.base.BaseViewModel
import com.minwook.rx_study.base.RxStudyApp
import com.minwook.rx_study.network.GithubRouter
import com.minwook.rx_study.network.response.Repositories
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GithubViewmodel(application: RxStudyApp): BaseViewModel(application) {

    val searchList: MutableLiveData<ArrayList<Repositories>> by lazy {
        MutableLiveData<ArrayList<Repositories>>()
    }

    override fun onCreate() {

    }

    fun getSearchRepositories(query: String) {
        GithubRouter.api().getSearchRepositories(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("Test", "items.count : ${it.items.count()}")
                Log.d("Test", "$it")

                searchList.postValue(it.items)
            }, {
                Log.e("Test", "getSearchRepositories error : ${it.localizedMessage}")
            }).addDisposable()
    }
}