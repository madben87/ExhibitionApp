package com.ben.exhibitionapp.ui.main

import android.app.Application
import com.ben.exhibitionapp.core.MyAndroidViewModel
import com.ben.exhibitionapp.ui.main.adapter.ExhibitItemAdapter
import com.ben.exhibitionapp.util.StateEnum
import com.ben.model.data_manager.ExhibitsLoader
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class MainViewModel(context: Application, val dataManager: ExhibitsLoader) :
    MyAndroidViewModel(context) {

    val adapter = ExhibitItemAdapter()

    init {
        bind()
    }

    fun bind() {
        loadData()
    }

    private fun loadData() {
        state.value = StateEnum.LOADING

        dataManager.getExhibitList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {
                    adapter.sedData(it)
                },
                onError = {
                    state.value = StateEnum.ERROR
                },
                onComplete = {
                    state.value = StateEnum.COMPLETE
                }
            ).addTo(disposables)
    }
}
