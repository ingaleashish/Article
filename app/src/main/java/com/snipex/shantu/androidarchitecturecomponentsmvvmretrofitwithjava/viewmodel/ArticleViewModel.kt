package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.repository.ArticleRepository
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response.ArticleResponse

class ArticleViewModel(application: Application) : AndroidViewModel(application) {

    private val articleRepository: ArticleRepository
    val articleResponseLiveData: LiveData<ArticleResponse>

    init {

        articleRepository = ArticleRepository()
        this.articleResponseLiveData = articleRepository.getMovieArticles("movies", "84a7decf3110498ea372bd16dd0601e8")
    }
}
