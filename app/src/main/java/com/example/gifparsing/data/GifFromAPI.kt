package com.example.gifparsing.data

import com.google.gson.annotations.SerializedName

data class GifFromAPI (
    @SerializedName("data") val data: ArrayList<GifData>
)

data class GifData (
    @SerializedName("type") val type: String,
    @SerializedName("id") val id: String,
    @SerializedName("url") val url: String,
    @SerializedName("rating") val rating: String,
    @SerializedName("images") val images: ImageList
)

data class ImageList (
    @SerializedName("fixed_height") val fixed_height: FixedHeight,
    @SerializedName("fixed_height_still") val fixed_height_still: FixedHeightStill
)

data class FixedHeight (
    @SerializedName("url") val url: String,
    @SerializedName("width") val width: String
)

data class FixedHeightStill (
    @SerializedName("url") val url: String,
    @SerializedName("width") val width: String
)
