package vp.videoplayer.mvvm.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Network {
    private const val BASE_URL="https://api.themoviedb.org/"

    fun getInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getApiServices():API= getInstance().create()
}