package com.ben.exhibitionapp.core

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ben.exhibitionapp.util.StateEnum
import io.reactivex.disposables.CompositeDisposable

open class MyAndroidViewModel(application: Application) : AndroidViewModel(application) {

    val disposables = CompositeDisposable()
    open val state = MutableLiveData<StateEnum>(StateEnum.NONE)

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}