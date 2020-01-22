package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Article {

    var title: String? = null
    @SerializedName("imageHref")
    @Expose
    var urlToImage: String? = null
    var description: String? = null
}
