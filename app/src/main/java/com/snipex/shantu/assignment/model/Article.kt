package com.snipex.shantu.assignment.model

import com.google.gson.annotations.SerializedName

class Article {

    var title: String? = null 
    @SerializedName("imageHref")
    var urlToImage: String? = null
    var description: String? = null
}
