package com.ben.model.model

import com.google.gson.annotations.SerializedName

class ExhibitRequest(@SerializedName("list") val list: List<Exhibit>) {
}