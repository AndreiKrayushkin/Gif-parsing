package com.example.gifparsing.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gifparsing.data.GifFromAPI
import com.example.gifparsing.data.GifRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class GifViewModel : ViewModel() {
    private val gifRepository = GifRepository()

    private val mutableGifLiveData = MutableLiveData<GifFromAPI>()
    var gifLiveData: LiveData<GifFromAPI> = mutableGifLiveData

    private val compositeDisposable = CompositeDisposable()

    fun fetchGif() {
        gifRepository.getGif()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { gif ->
                mutableGifLiveData.value = gif
            }.also {
                compositeDisposable.add(it)
            }
    }
}