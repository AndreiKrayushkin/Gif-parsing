package com.example.gifparsing.data

import io.reactivex.Single

interface GifDataFromAPIImpl {
    fun getGif(appKey: String, limit: Int): Single<GifFromAPI>
}