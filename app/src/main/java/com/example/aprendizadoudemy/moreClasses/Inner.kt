package com.example.aprendizadoudemy.moreClasses

// Inner class

class Computer (val processorModel: String) {

    inner class Memory (val level: Int) {
        fun getMemoryLevel(): Int {
            println(processorModel)
            return 70
        }
    }

}

fun main(args: Array<String>) {

    val m1: Computer.Memory = Computer("Intel").Memory(2)
    m1.getMemoryLevel()
    m1.level
}