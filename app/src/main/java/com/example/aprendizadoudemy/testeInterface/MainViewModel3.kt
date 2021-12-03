package com.example.aprendizadoudemy.testeInterface

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel3(
    private var testeRepository: TesteRepository
) : ViewModel() {

    private val _getResult = MutableLiveData<Int>()
    val getResult: LiveData<Int> = _getResult

    fun sendValue(number1: Int, number2: Int) = viewModelScope.launch {
        try {
            _getResult.value = testeRepository.teste1(number1, number2)
        } catch (e: Exception) { }
    }
}
