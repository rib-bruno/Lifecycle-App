package com.example.lifecycleapp

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
   var counter = 0
      //leitura pública, atribuição privada
      private set

   fun increment() {
      counter++
   }
}