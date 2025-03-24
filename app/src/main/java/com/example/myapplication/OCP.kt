package com.example.myapplication

//"Software entities (classes, modules, functions, etc.)
// should be open for extension but closed for modification."

interface PaymentProcessor {
    fun processPayment(amount: Double)
}

class CreditCardPayment : PaymentProcessor {
    override fun processPayment(amount: Double) {
        println("Processing credit card payment of $$amount")
    }
}

class PaypalPayment : PaymentProcessor {
    override fun processPayment(amount: Double) {
        println("Processing PayPal payment of $$amount")
    }
}

class PaymentService(private val processor: PaymentProcessor) {
    fun makePayment(amount: Double) {
        processor.processPayment(amount)
    }
}

fun main() {
    val creditCardPayment = PaymentService(CreditCardPayment())
    val paypalPayment = PaymentService(PaypalPayment())

    creditCardPayment.makePayment(100.0)
    paypalPayment.makePayment(150.0)
}
