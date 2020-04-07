package com.snipex.shantu.assignment.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.snipex.shantu.assignment.model.Article

class ArticleResponse {
    @SerializedName("title") 
    @Expose
    var status: String? = null


    @SerializedName("rows")
    var articles: List<Article>? = null
}
