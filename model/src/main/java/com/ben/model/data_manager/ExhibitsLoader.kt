package com.ben.model.data_manager

import com.ben.model.model.Exhibit
import io.reactivex.Observable

interface ExhibitsLoader {
    fun getExhibitList(): Observable<List<Exhibit>>
}