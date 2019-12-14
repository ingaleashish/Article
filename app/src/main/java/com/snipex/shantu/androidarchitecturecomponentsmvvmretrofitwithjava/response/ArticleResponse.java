package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Article;

import java.util.List;

public class ArticleResponse {
    @SerializedName("title")
    @Expose
    private String status;
   /* @SerializedName("title")
    @Expose
    private Integer totalResults;*/
    @SerializedName("rows")
    @Expose
    private List<Article> rows = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   /* public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }*/

    public List<Article> getArticles() {
        return rows;
    }

    public void setArticles(List<Article> articles) {
        this.rows = articles;
    }
}
