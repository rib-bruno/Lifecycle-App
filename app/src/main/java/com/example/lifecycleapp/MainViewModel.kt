package com.example.lifecycleapp

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    //não precisa mais ser var pq ele não vai sofrer modificação da referência, e sim do value
    private val _counter = NumberLiveData()

    //tipar ela pra superclasse du mutable
    val counter: LiveData<Int> = _counter
    //leitura pública, atribuição privada

    var incrementBy = 1

    fun increment() {
        //pode ser nulo
        val number = _counter.value ?: 0
        _counter.value = number + incrementBy
    }
}

//livedata customizado
class NumberLiveData(initial: Int = 0) : MutableLiveData<Int>(initial) {
    //inicializado o observe
    override fun onActive() {
        super.onActive()
        Log.d("MainViewModel", "onActive")
    }

    override fun onInactive() {
        super.onInactive()
        Log.d("MainViewModel", "onInactive")
    }
}