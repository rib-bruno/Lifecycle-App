package com.example.lifecycleapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.activity.viewModels
import com.example.lifecycleapp.databinding.ActivityMainBinding
import com.example.lifecycleapp.presentation.ViewModelFactory
import com.example.lifecycleapp.presentation.counter.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    //como está dentro da activity, não precisa colocar o prefixo
    //passando no generics o nome da viewmodel q voce quer recuperar
    private val viewModel by viewModels<MainViewModel> {
        ViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

//        viewModel.counter.observe(this) {counter ->
//            //o que fazer se o valor for mudado
//            binding.tvCounter.text = counter.toString()
//        }

        binding.fab.setOnClickListener { view ->
         viewModel.increment()

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}