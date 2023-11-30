package com.example.lifecycleapp.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.lifecycleapp.data.CounterRepositoryImpl
import com.example.lifecycleapp.presentation.counter.MainViewModel
import java.lang.IllegalArgumentException

//classe responsável por fabricar a viewmodel
//implementar a interface
class ViewModelFactory : ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        //conhecer o que é preciso para construir a instância.
        //então, tudo bem ele conhcer o view model, passar as dependências pra esse viewmodel

        if(modelClass == MainViewModel::class.java) {
            return MainViewModel(repository = CounterRepositoryImpl()) as T
        }

        if (modelClass == SecondViewModel::class.java) {
            return SecondViewModel() as T
        }

        throw IllegalArgumentException("Unknown ViewModel instance for $modelClass")
    }
}