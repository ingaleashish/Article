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
    private var myRecyclerView: RecyclerView? = null
    private var progressCircularArticle: ProgressBar? = null
    private var layoutManager: LinearLayoutManager? = null
    private var adapter: ArticleAdapter? = null
    private val articleArrayList = ArrayList<Article>()
    internal lateinit var articleViewModel: ArticleViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialization()

        getArticles()
    }

    /**
     * initialization of views and others
     *
     * @param @null
     */
    private fun initialization() {
        progressCircularArticle = findViewById<View>(R.id.progress_circular_movie_article) as ProgressBar
        myRecyclerView = findViewById<View>(R.id.my_recycler_view) as RecyclerView

        // use a linear layout manager
        layoutManager = LinearLayoutManager(this@MainActivity)
        myRecyclerView!!.layoutManager = layoutManager

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        myRecyclerView!!.setHasFixedSize(true)

        // adapter
        adapter = ArticleAdapter(this@MainActivity, articleArrayList)
        myRecyclerView!!.adapter = adapter

        // View Model
        articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel::class.java)
    }

    /**
     * get articles from news api
     *
     * @param @null
     */
    private fun getArticles() {
        articleViewModel.articleResponseLiveData.observe(this, Observer { articleResponse ->
            if (articleResponse != null) {
                this@MainActivity.setTitle(articleResponse.status)
                progressCircularArticle!!.visibility = View.GONE
                val articles = articleResponse.articles
                articleArrayList.addAll(articles!!)
                adapter!!.notifyDataSetChanged()
            }
        })
    }

    companion object {

        private val TAG = MainActivity::class.java!!.getSimpleName()
    }
}
