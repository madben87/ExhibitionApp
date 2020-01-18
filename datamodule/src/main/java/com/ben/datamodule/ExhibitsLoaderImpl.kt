package com.ben.datamodule

import android.content.Context
import com.ben.model.data_manager.ExhibitsLoader
import com.ben.model.model.Exhibit
import com.ben.model.model.ExhibitRequest
import com.google.gson.Gson
import io.reactivex.Observable
import org.koin.core.KoinComponent
import java.util.concurrent.Callable

class ExhibitsLoaderImpl(val context: Context) : ExhibitsLoader, KoinComponent {

    override fun getExhibitList(): Observable<List<Exhibit>> {
        /*var json = ""
        val dataPath = "data.json"
        context.assets.open(dataPath).bufferedReader().use {
            json = it.readText()
        }
        val request = Gson().fromJson(json, ExhibitRequest::class.java)*/
        //return request.list

        return Observable.fromCallable(object : Callable<List<Exhibit>> {
            override fun call(): List<Exhibit> {
                var json = ""
                val dataPath = "data.json"
                context.assets.open(dataPath).bufferedReader().use {
                    json = it.readText()
                }
                return Gson().fromJson(json, ExhibitRequest::class.java).list
            }
        })
    }
}