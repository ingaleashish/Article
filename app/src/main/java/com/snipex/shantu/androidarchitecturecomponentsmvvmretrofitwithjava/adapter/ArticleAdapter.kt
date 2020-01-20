package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.R
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Article

import java.util.ArrayList

class ArticleAdapter(private val context: Context, internal var articleArrayList: ArrayList<Article>) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ArticleAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_each_row_movie_article, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ArticleAdapter.ViewHolder, i: Int) {
        val article = articleArrayList[i]
        viewHolder.tvTitle.text = article.title
        viewHolder.tvDescription.text = article.description
        Glide.with(context)
                .load(article.urlToImage)
                /*.error(Glide.with(viewHolder.imgViewCover).load(R.drawable.ic_launcher_background))*/
                .into(viewHolder.imgViewCover)
    }

    override fun getItemCount(): Int {
        return articleArrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgViewCover: ImageView
        val tvTitle: TextView
        val tvDescription: TextView

        init {

            imgViewCover = itemView.findViewById<View>(R.id.imgViewCover) as ImageView
            tvTitle = itemView.findViewById<View>(R.id.tvTitle) as TextView
            tvDescription = itemView.findViewById<View>(R.id.tvDescription) as TextView
        }
    }
}
