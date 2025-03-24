package com.example.myapplication

// Abstraction
interface Engine {
    fun start(): String
}

// Low-level module
// Both should depend on abstractions.
class DieselEngine : Engine {
    //  details.
    // Details should depend on abstractions.
    override fun start() = "Diesel engine started"
}

// High-level module
// Both should depend on abstractions.
class Car(private val engine: Engine) {
    //  details.
    fun drive() {
        //Details should depend on abstractions.
        println(engine.start())
    }
}
//tHIS CODE FOLLOW DSP


fun main() {
    val engine: Engine = DieselEngine()
    val car = Car(engine)
    car.drive()
}
