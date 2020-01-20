package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.R
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.adapter.ArticleAdapter
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Article
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.viewmodel.ArticleViewModel

import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    companion object {

        private val TAG = MainActivity::class.java!!.getSimpleName()
    }
}
