package com.snipex.shantu.assignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup 
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.snipex.shantu.assignment.R
import com.snipex.shantu.assignment.model.Article
import com.squareup.picasso.Picasso
import java.util.*


class ArticleAdapter(private val context: Context, internal var articleArrayList: ArrayList<Article>) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ArticleAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_each_row_movie_article, viewGroup, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: ArticleAdapter.ViewHolder, i: Int) {
        val article = articleArrayList[i]
        viewHolder.tvTitle.text = article.title
        viewHolder.tvDescription.text = article.description
        Picasso.with(context).load(article.urlToImage).placeholder(R.mipmap.ic_launcher).into(viewHolder.imgViewCover)


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
