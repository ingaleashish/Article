package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.R;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.adapter.ArticleAdapter;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Article;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.viewmodel.ArticleViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView myRecyclerView;
    private ProgressBar progressCircularArticle;
    private LinearLayoutManager layoutManager;
    private ArticleAdapter adapter;
    private ArrayList<Article> articleArrayList = new ArrayList<>();
    ArticleViewModel articleViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();

        getArticles();
    }

    /**
     * initialization of views and others
     *
     * @param @null
     */
    private void initialization() {
        progressCircularArticle = (ProgressBar) findViewById(R.id.progress_circular_movie_article);
        myRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(MainActivity.this);
        myRecyclerView.setLayoutManager(layoutManager);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        myRecyclerView.setHasFixedSize(true);

        // adapter
        adapter = new ArticleAdapter(MainActivity.this, articleArrayList);
        myRecyclerView.setAdapter(adapter);

        // View Model
        articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel.class);
    }

    /**
     * get articles from news api
     *
     * @param @null
     */
    private void getArticles() {
        articleViewModel.getArticleResponseLiveData().observe(this, articleResponse -> {
            if (articleResponse != null) {
                MainActivity.this.setTitle(articleResponse.getStatus());
                progressCircularArticle.setVisibility(View.GONE);
                List<Article> articles = articleResponse.getArticles();
                articleArrayList.addAll(articles);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
