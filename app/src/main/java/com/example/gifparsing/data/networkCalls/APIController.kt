package com.example.gifparsing.data.networkCalls

import com.example.gifparsing.data.GifDataFromAPIImpl
import com.example.gifparsing.data.GifFromAPI
import com.example.gifparsing.data.networkCalls.APIController.RetrofitHolder.retrofit
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class APIController : GifDataFromAPIImpl {
    override fun getGif(appKey: String, limit: Int): Single<GifFromAPI> =
        retrofit.create(GifAPI::class.java).getGifTrading(appKey, limit)
            .subscribeOn(Schedulers.io())

    private object RetrofitHolder {
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl("https://api.giphy.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}