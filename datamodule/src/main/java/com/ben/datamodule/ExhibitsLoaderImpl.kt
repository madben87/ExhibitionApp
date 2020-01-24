package com.ben.datamodule

import android.content.Context
import com.ben.model.data_manager.ExhibitsLoader
import com.ben.model.model.Exhibit
import com.ben.model.model.ExhibitRequest
import com.google.gson.Gson
import io.reactivex.Observable
import kotlinx.coroutines.*
import org.koin.core.KoinComponent
import java.util.ArrayList
import java.util.concurrent.Callable
import kotlin.coroutines.CoroutineContext

class ExhibitsLoaderImpl(val context: Context) : ExhibitsLoader, KoinComponent {

    override fun getExhibitList() : List<Exhibit> {
        var json = ""
        val dataPath = "data.json"
        context.assets.open(dataPath).bufferedReader().use {
            json = it.readText()
        }
        return Gson().fromJson(json, ExhibitRequest::class.java).list
    }
}