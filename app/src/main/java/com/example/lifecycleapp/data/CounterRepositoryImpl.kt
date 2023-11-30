package com.example.lifecycleapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lifecycleapp.domain.CounterRepository

class CounterRepositoryImpl : CounterRepository {

    //não precisa mais ser var pq ele não vai sofrer modificação da referência, e sim do value
    private val counter = MutableLiveData(0)

    //somente leitura
    override fun getCounter(): LiveData<Int> = counter

    override fun incrementCounterBy(increment: Int) {
        //pode ser nulo
        val number = counter.value ?: 0
        counter.value = number + increment
    }
}
