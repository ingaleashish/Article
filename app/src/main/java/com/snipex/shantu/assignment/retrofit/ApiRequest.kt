package com.snipex.shantu.assignment.retrofit

import com.snipex.shantu.assignment.response.ArticleResponse

import retrofit2.Call
import retrofit2.http.GET

interface ApiRequest {

    @get:GET("2iodh4vg0eortkl/facts.json")
    val movieArticles: Call<ArticleResponse>
}
