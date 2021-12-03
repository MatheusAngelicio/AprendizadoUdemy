package com.example.aprendizadoudemy.testeInterface

interface TesteRepository {

    suspend fun teste1(numero1: Int, numero2: Int): Int

    suspend fun teste2(numero: Int): Int
}