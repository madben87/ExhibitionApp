package com.ben.model.model

import com.google.gson.annotations.SerializedName

data class Exhibit(
    @SerializedName("title")
    var title: String,
    @SerializedName("images")
    var images: ArrayList<String>
) {
}