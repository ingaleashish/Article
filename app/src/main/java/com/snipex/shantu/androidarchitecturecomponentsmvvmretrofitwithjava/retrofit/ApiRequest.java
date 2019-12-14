package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.retrofit;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response.ArticleResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {

    @GET("2iodh4vg0eortkl/facts.json")
    Call<ArticleResponse> getMovieArticles();
}
