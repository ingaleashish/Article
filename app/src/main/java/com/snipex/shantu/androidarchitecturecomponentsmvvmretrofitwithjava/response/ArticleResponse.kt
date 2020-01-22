package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Article

class ArticleResponse {
    @SerializedName("title")
    @Expose
    var status: String? = null

    @SerializedName("rows")
    @Expose
    var articles: List<Article>? = null
}
