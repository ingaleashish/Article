package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view

/**
 * Created by Ashish Ingale
 */

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class ArticleApplication : Application() {

    private val isNetworkConnected: Boolean
        get() {
            val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val activeNetwork = cm.activeNetworkInfo
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting
        }

    override fun onCreate() {
        super.onCreate()

        if (instance == null) {
            instance = this
        }
    }

    companion object {

        var instance: ArticleApplication? = null
            private set

        fun hasNetwork(): Boolean {
            return instance!!.isNetworkConnected
        }
    }
}
