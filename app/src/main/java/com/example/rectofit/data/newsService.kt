package com.example.rectofit
import com.example.rectofit.model.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
//https://newsapi.org/v2/top-headlines?country=us&apiKey=API_KEY
//https://newsapi.org/v2/everything?q=tesla&from=2023-04-17&sortBy=publishedAt&apiKey=API_KEY
const val Base_URL = "https://newsapi.org/"
const val API_KEY = "dfec4f8f04e64c448c8d8a561d9cd779"

interface NewsInterface{
    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadLines(@Query("country") Country: String, @Query("page") Page: Int) : Call<News>


    //https://newsapi.org/v2/top-headlines?apiKey=$API_KEY&Country=in&Page=1
    //https://newsapi.org/v2/top-headlines?apiKey=dfec4f8f04e64c448c8d8a561d9cd779&Country=in&Page=1
}
object NewsService{
    val newsInstance : NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}