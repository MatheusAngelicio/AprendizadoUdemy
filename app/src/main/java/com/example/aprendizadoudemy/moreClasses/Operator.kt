package com.example.aprendizadoudemy.moreClasses

data class Number(val n1: Int, val n2: Int) {
    // Para somar duas classes
    operator fun plus(add: Number): Int {
       return add.n1 + add.n2
    }

    operator fun inc(): Number {
        return this
    }

    fun main(args: Array<String>) {
        var f1 = Number(3, 2)
        var f2 = Number(5, 3)

        println(f1 + f2)
        f1++
        f2++
    }

}