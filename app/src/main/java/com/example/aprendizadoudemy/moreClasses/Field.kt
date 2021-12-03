package com.example.aprendizadoudemy.moreClasses

import java.lang.Exception

class Car(val model: String, val maxSpeed:Int) {
    var currentSpeed: Int = 0
        // Sempre que currentSpeed receber um valor, vai cair no set(value)
        set(value) {
            if (value > maxSpeed) {
                throw Exception("Velocidade maior que a permitida")
            } else {
                field = value
            }
        }
        get() {
            // regras de negocio
            return field
        }
}

fun main(args: Array<String>) {
    val c1 = Car("", 220)
    c1.currentSpeed = 500

    print(c1.currentSpeed)

}