package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.repository

import android.content.ContentValues.TAG
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import android.util.Log
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.espresso.SimpleIdlingResource

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response.ArticleResponse
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.retrofit.ApiRequest
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.retrofit.RetrofitRequest
import java.net.HttpURLConnection

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleRepository {
    private val apiRequest: ApiRequest

    init {
        apiRequest = RetrofitRequest.retrofitInstance!!.create(ApiRequest::class.java!!)
    }

    fun getMovieArticles(query: String, key: String): LiveData<ArticleResponse> {

        val data = MutableLiveData<ArticleResponse>()
        apiRequest.movieArticles
                .enqueue(object : Callback<ArticleResponse> {


                    override fun onResponse(call: Call<ArticleResponse>, response: Response<ArticleResponse>) {
                        Log.d(TAG, "onResponse response:: $response")
                        Log.d(TAG, "onResponse: " + response.body()!!)
                        if (response.raw().networkResponse() != null && response.raw().networkResponse()!!.code() == HttpURLConnection.HTTP_NOT_MODIFIED) {
                            Log.d(TAG, "onResponse: response is from NETWORK...")
                            Log.d(TAG, "onResponse: response hasn't changed")


                            if (response.body() != null) {
                                data.setValue(response.body())

                                //Log.d(TAG, "articles total result:: " + response.body().getTotalResults());
                                Log.d(TAG, "articles size:: " + response.body()!!.articles?.size)
                                Log.d(TAG, "articles title pos 0:: " + response.body()!!.articles?.get(0)?.title)
                            }
                        } else if (response.raw().networkResponse() != null && response.raw().networkResponse()!!.code() != HttpURLConnection.HTTP_NOT_MODIFIED) {
                            Log.d(TAG, "onResponse: response is from NETWORK...")
                            Log.d(TAG, "onResponse: response changed")

                            if (response.body() != null) {
                                data.setValue(response.body())

                                //                                Log.d(TAG, "articles total result:: " + response.body().getTotalResults());
                                Log.d(TAG, "articles size:: " + response.body()!!.articles?.size)
                                Log.d(TAG, "articles title pos 0:: " + response.body()!!.articles?.get(0)?.title)
                            }
                        } else if (response.raw().cacheResponse() != null && response.raw().networkResponse() == null) {
                            Log.d(TAG, "onResponse: response is from CACHE...")

                            if (response.body() != null) {
                                data.setValue(response.body())

                                //   Log.d(TAG, "articles total result:: " + response.body().getTotalResults());
                                Log.d(TAG, "articles size:: " + response.body()!!.articles?.size)
                                Log.d(TAG, "articles title pos 0:: " + response.body()!!.articles?.get(0)?.title)
                            }
                        }
                    }

                    override fun onFailure(call: Call<ArticleResponse>, t: Throwable) {
                        data.setValue(null)
                    }
                })
        return data
    }

}
