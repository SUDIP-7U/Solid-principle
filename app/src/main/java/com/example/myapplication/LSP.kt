package com.example.myapplication

//"Objects of a superclass should be
//replaceable with objects of its subclasses
// without altering the correctness of the program."

open class Bird {
    fun walk() {
        println("Walking on the ground")
    }
}

open class FlyingBird : Bird() {
    open fun fly() {
        println("Flying in the sky")
    }
}

class Sparrow : FlyingBird() {
    override fun fly() {
        println("Sparrow flying")
    }
}

class Ostrich : Bird()

fun makeBirdFly(bird: FlyingBird) {
    bird.fly()
}

fun main() {
    val sparrow = Sparrow()
    makeBirdFly(sparrow)  // Works fine

    val ostrich = Ostrich()
    ostrich.walk()  // No violation
}




//Bad Example
//open class Bird {
//    open fun fly() {
//        println("Flying high in the sky")
//    }
//}
//
//class Ostrich : Bird() {
//    override fun fly() {
//        // Ostriches can't fly!
//        throw UnsupportedOperationException("Ostriches can't fly")
//    }
//}
//
//fun makeBirdFly(bird: Bird) {
//    bird.fly()
//}
//
//fun main() {
//    val sparrow = Bird()
//    makeBirdFly(sparrow)  // Works fine
//
//    val ostrich = Ostrich()
//    makeBirdFly(ostrich)  // Throws an exception - Violates LSP
//}