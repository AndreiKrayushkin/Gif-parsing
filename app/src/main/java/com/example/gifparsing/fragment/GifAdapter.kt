package com.example.gifparsing.fragment

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.gifparsing.R
import com.example.gifparsing.data.GifFromAPI
import com.example.gifparsing.databinding.ItemGifBinding
import com.example.gifparsing.util.Constants.LOG_VIEW

/**
 * Адатер получает позицию гифки
 */
class GifAdapter (private var getPosition: Int): RecyclerView.Adapter<GifAdapter.GifViewHolder>() {
    private var listURI = mutableListOf<GifFromAPI>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder =
        GifViewHolder(ItemGifBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        holder.bind(listURI[position], getPosition)
    }

    override fun getItemCount() = listURI.size

    /**
     * ID и Gif-анимация подставляется в RecyclerView
     */
    class GifViewHolder(private val binding: ItemGifBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(gifUri: GifFromAPI, number: Int) {
            Glide.with(binding.root.context)
                .asGif()
                .load(gifUri.data[number].images.fixed_height.url)
                .into(binding.itemGif)
            binding.itemGifTextInfo.text = gifUri.data[number].id
            Log.v(LOG_VIEW, "${gifUri.data[number].id}")
        }
    }

    fun addGif(gifList: GifFromAPI) {
        listURI.add(gifList)
        Log.v(LOG_VIEW, "list size = ${listURI.size}, $listURI")
        notifyDataSetChanged()
    }
}