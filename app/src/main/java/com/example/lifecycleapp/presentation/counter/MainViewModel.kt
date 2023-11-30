package com.example.lifecycleapp.presentation.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lifecycleapp.data.CounterRepositoryImpl
import com.example.lifecycleapp.domain.CounterRepository

class MainViewModel(
    private val repository: CounterRepository
) : ViewModel() {

    //tipar ela pra superclasse du mutable
    val counter: LiveData<Int> = repository.getCounter()
    //leitura pública, atribuição privada

    //input do usuário
    var incrementBy = 1

    fun increment() {
        //valor sendo salvo na memória
        repository.incrementCounterBy(incrementBy)
    }
}
