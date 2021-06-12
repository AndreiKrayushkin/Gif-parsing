package com.example.gifparsing.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gifparsing.R
import com.example.gifparsing.data.GifFromAPI
import com.example.gifparsing.databinding.FragmentGifsListBinding
import com.example.gifparsing.util.Constants.LOG_VIEW
import com.example.gifparsing.viewModel.GifViewModel

class GifFragment : Fragment(R.layout.fragment_gifs_list) {
    private lateinit var binding: FragmentGifsListBinding
    private lateinit var viewModelProvider: ViewModelProvider
    private lateinit var loadAdapter: GifAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGifsListBinding.bind(view)
        viewModelProvider = ViewModelProvider(this)
        viewModelProvider.get(GifViewModel::class.java).also {
            it.gifLiveData.observe(viewLifecycleOwner, {data -> loadAdapter.addGif(data)})
            it.gifLiveData.observe(viewLifecycleOwner, {data -> showContent(data)})
            it.fetchGif()
        }
        /**
         * в адаптер передается позиция №8, но не совсем понимаю, как передать размер адаптера,
         * чтобы отобразить последовательно необходимое количество Gif
         */
        loadAdapter = GifAdapter(8)
        binding.listGifs.apply {
            adapter = loadAdapter
            layoutManager = LinearLayoutManager(context)
        }

    }

    /**
     * проверка данных, полученных с сайта
     */
    private fun showContent(gif: GifFromAPI) {
        binding.apply {
            for (i in 0..9) {
                Log.v(LOG_VIEW, "This is id ==== ${gif.data[i].id} ////// This is URL ==== ${gif.data[i].url}\n")
                Log.v(LOG_VIEW, "${gif.data.size}")
            }
        }
    }
}