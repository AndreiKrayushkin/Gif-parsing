package com.example.gifparsing.data

import com.example.gifparsing.data.networkCalls.APIController
import io.reactivex.Single

class GifRepository {
    private val newDataSource: GifDataFromAPIImpl = APIController()

    /**
     * ключ и количество получаемых Gif
     */
    fun getGif(): Single<GifFromAPI> =
        newDataSource.getGif("lTPHKxEBVXJelZOuyrQHmoFZmuPr16Xc", 10)
}