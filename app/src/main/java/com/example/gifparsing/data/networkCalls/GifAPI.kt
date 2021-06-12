package com.example.gifparsing.data.networkCalls

import com.example.gifparsing.data.GifFromAPI
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GifAPI {
    @GET("v1/gifs/trending")
    fun getGifTrading(@Query("api_key") apiKey: String,
                      @Query("limit") limit: Int): Single<GifFromAPI>
}