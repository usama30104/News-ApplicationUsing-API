package com.example.rectofit.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rectofit.databinding.ItemLayoutBinding
import com.example.rectofit.model.Artical


class NewsAdapter(val context: Context,val list: List<Artical>): RecyclerView.Adapter<NewsAdapter.ArticalViewHolder>(){

   inner class ArticalViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
       fun binddata(artical: Artical) {
           binding.titleNews.text = artical.title
           binding.descNews.text = artical.description
           Glide.with(context).load(artical.urlToImage).into(binding.imageView)
           binding.imageView.setOnClickListener{
               Toast.makeText(context, "Hope You Like It", Toast.LENGTH_SHORT).show()
           }

       }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticalViewHolder {
       return ArticalViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ArticalViewHolder, position: Int) {
        holder.binddata(list[position])
    }
}