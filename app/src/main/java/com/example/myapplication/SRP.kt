package com.example.myapplication

//"A class should have only one reason to change."

// Responsible for validation
class UserValidator {
    fun isValid(name: String, age: Int): Boolean {
        return name.isNotBlank() && age > 0
    }
}

// Responsible for data persistence
class UserRepository {
    fun saveUser(name: String, age: Int) {
        println("User saved: $name, Age: $age")
    }
}

// Responsible for sending emails
class EmailService {
    fun sendWelcomeEmail(name: String) {
        println("Welcome email sent to $name")
    }
}

// User manager class combining components
class UserManager(
    private val validator: UserValidator,
    private val repository: UserRepository,
    private val emailService: EmailService
) {
    fun registerUser(name: String, age: Int) {
        if (validator.isValid(name, age)) {
            repository.saveUser(name, age)
            emailService.sendWelcomeEmail(name)
        } else {
            println("Invalid user data")
        }
    }
}

fun main() {
    val userManager = UserManager(UserValidator(), UserRepository(), EmailService())
    userManager.registerUser("John", 25)
}
