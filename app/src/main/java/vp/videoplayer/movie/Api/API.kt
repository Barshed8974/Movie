package vp.videoplayer.mvvm.Api

import retrofit2.http.GET
import retrofit2.http.Query
import vp.videoplayer.movie.ModelClasses.Response

interface API {
    @GET("3/discover/movie?api_key=0c8bb8e96b542e1f2d7753de9c905237")
    suspend fun getQuotes(@Query("page") page: Int): Response
}