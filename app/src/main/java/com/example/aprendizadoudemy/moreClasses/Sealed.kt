package com.example.aprendizadoudemy.moreClasses

sealed class Result {
    object Success : Result()
    object Error : Result()
}

class Repo {
    fun execute(value: Int): Result {
        return if (value % 2 == 0) {
            Result.Success
        } else {
            Result.Error
        }
    }
}

fun main(args: Array<String>) {

        val randomNumber = (0..10).random()
        val r1 = Repo()
        val result: Result = r1.execute(randomNumber)
        when (result) {
            is Result.Success -> {
                print("Deu sucesso")
            }
            is Result.Error -> {
                print("Deu erro")
            }
        }



}