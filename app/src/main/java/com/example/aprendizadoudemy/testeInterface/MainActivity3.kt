package com.example.aprendizadoudemy.testeInterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aprendizadoudemy.R
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {

    private val viewmodel: MainViewModel3 by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val repository: TesteRepository = TesteRepositoryImpl()
                return MainViewModel3(repository) as T
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        observeViewModel()

        initViews()

    }

    private fun initViews() {

        button.setOnClickListener {
            viewmodel.sendValue(
                number1.text.toString().toInt(),
                number2.text.toString().toInt()
            )
        }
    }

    private fun observeViewModel() {
        viewmodel.getResult.observe(this) {
            result.text = it.toString()
        }
    }
}