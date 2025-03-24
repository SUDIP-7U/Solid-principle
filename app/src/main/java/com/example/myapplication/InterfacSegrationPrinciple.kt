package com.example.myapplication


fun main() {
    val humanWorker = HumanWorker()
    val robot = RobotWorker()

    makeWorker(humanWorker)
    makerobotwoker(robot)

}


interface Workable {
    fun work()
}

interface eatable {
    fun eat()
}

class HumanWorker : Kikoro(), eatable {
    override fun eat() {
        println("eating...")
    }
}

class RobotWorker : Kikoro(), Workable {
    override fun work() {
        println("Working...")
   }
}

//This is our code following ISP

open class Kikoro {

}

fun makeWorker(eatable: eatable) {
    eatable.eat()
}

fun makerobotwoker(workable: Workable){
    workable.work()
}

