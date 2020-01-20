package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Article

class ArticleResponse {
    @SerializedName("title")
    @Expose
    var status: String? = null
    /* @SerializedName("title")
    @Expose
    private Integer totalResults;*/
    /* public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }*/

    @SerializedName("rows")
    @Expose
    var articles: List<Article>? = null
}
