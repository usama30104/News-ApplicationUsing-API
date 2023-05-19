package com.example.rectofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.rectofit.NewsService
import com.example.rectofit.databinding.ActivityMainBinding
import com.example.rectofit.model.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter: NewsAdapter
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(binding.root)
        getNews()
    }

    private fun getNews() {
        val news = NewsService.newsInstance.getHeadLines("in", 1)
        news.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val newsd = response.body()

//                Log.i("onResponse: ", "${response.errorBody()}")
                if (newsd!=null){
                    Log.d("testing", "yfdydy $newsd")
                    adapter = NewsAdapter(this@MainActivity, newsd.articles)
                    binding.recycleView.adapter = adapter

                }
            }
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("testing", "Error found",t)

            }

        })
    }
}