package com.example.aprendizadoudemy.testeInterface


class TesteRepositoryImpl : TesteRepository {
    override suspend fun teste1(numero1: Int, numero2: Int): Int {
        Thread.sleep(1000L)
        var rnds = 0
        rnds = if (numero1 < numero2) {
            (numero1..numero2).random()
        } else {
            (numero2..numero1).random()
        }
        return rnds
    }

    override suspend fun teste2(numero: Int): Int {
        return numero + 1
    }

}