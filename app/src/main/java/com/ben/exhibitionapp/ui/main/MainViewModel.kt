package com.ben.exhibitionapp.ui.main

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ben.exhibitionapp.core.MyAndroidViewModel
import com.ben.model.data_manager.ExhibitsLoader
import com.ben.model.model.Exhibit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(context: Application, val dataManager: ExhibitsLoader) :
    MyAndroidViewModel(context) {

    private val liveData = MutableLiveData<List<Exhibit>>()

    init {
        bind()
    }

    fun bind() {
        launch(Dispatchers.Main) {
            loadData()
        }
    }

    fun getData() : MutableLiveData<List<Exhibit>> {
        return liveData
    }

    private fun loadData() {
        liveData.value = dataManager.getExhibitList()
    }
}
