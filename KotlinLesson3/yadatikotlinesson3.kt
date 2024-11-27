// File: yadatikotlinlesson3.kt

// Author: Akhil Yadati
// Complete Kotlin Lesson 3 Code - Covers all topics from both Part 1 and Part 2 of the pathway

// 1. Create a Class
class Animal(val name: String, var age: Int) {
    fun speak() {
        println("$name makes a sound!")
    }
}

// 2. Add Class Constructors
class Person(val firstName: String, val lastName: String, var age: Int) {
    init {
        println("Person initialized: $firstName $lastName, Age: $age")
    }
}

// 3. Learn about Visibility Modifiers
class PublicClass {
    public var publicProperty = "I am accessible anywhere!"
    private var privateProperty = "I am accessible only in this class!"
    protected var protectedProperty = "I am accessible in subclasses."
}

// 4. Subclasses and Inheritance
open class Vehicle(val make: String, val model: String) {
    open fun start() {
        println("$make $model is starting.")
    }
}

class Car(make: String, model: String, val numDoors: Int) : Vehicle(make, model) {
    override fun start() {
        println("$make $model with $numDoors doors is starting.")
    }
}

// 5. Abstract Classes and Interfaces
abstract class Appliance {
    abstract fun turnOn()
}

class WashingMachine : Appliance() {
    override fun turnOn() {
        println("Washing Machine is now ON.")
    }
}

interface Flyable {
    fun fly()
}

class Bird : Flyable {
    override fun fly() {
        println("Bird is flying.")
    }
}

// 6. Data Classes
data class Book(val title: String, val author: String)

// 7. Singleton and Companion Objects
class SingletonExample private constructor() {
    companion object {
        val instance = SingletonExample()
        fun showInstance() = println("Singleton instance accessed")
    }
}

class Choice {
    companion object {
        var name: String = "lyric"
        fun showDescription(name: String) = println("My favorite $name")
    }
}

// 8. Enum Classes
enum class Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

// 9. Delegation
interface SoundBehavior {
    fun makeSound()
}

class Dog : SoundBehavior {
    override fun makeSound() = println("Bark!")
}

// Part 2: Pairs, Triples, Collections, Constants, and Extension Functions

// Pairs and Triples
fun pairAndTripleExamples() {
    val colorPair = Pair("Favorite Color", "Blue")
    val songTriple = Triple("Favorite Song", "Imagine", 1971)

    println("Pair example: ${colorPair.first} is ${colorPair.second}")
    println("Triple example: ${songTriple.first} is ${songTriple.second} released in ${songTriple.third}")
}

// Collections Example
fun peopleCollection() {
    val people = listOf(
        Person("Alice", "Smith", 28),
        Person("Bob", "Johnson", 34),
        Person("Catherine", "Brown", 24)
    )

    println("People in collection:")
    people.forEach { println(it) }
}

// Constants
const val MAX_AGE = 120

// Extension Functions
fun String.greet() = "Hello, $this!"

// Higher-Order Functions
fun performOperation(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

// Main Function to Execute All Lessons
fun main() {
    // Lesson 1 - Class and Method
    val animal = Animal("Dog", 3)
    animal.speak()  // Dog makes a sound!

    // Lesson 2 - Class with Constructor
    val person = Person("John", "Doe", 25)

    // Lesson 3 - Visibility Modifiers
    val publicClass = PublicClass()
    println(publicClass.publicProperty)
    // privateProperty and protectedProperty are not accessible here

    // Lesson 4 - Subclass and Inheritance
    val myCar = Car("Toyota", "Camry", 4)
    myCar.start()  // Toyota Camry with 4 doors is starting.

    // Lesson 5 - Abstract Class and Interface
    val washingMachine = WashingMachine()
    washingMachine.turnOn()

    val bird = Bird()
    bird.fly()  // Bird is flying.

    // Lesson 6 - Data Class
    val book = Book("1984", "George Orwell")
    println(book)  // Book(title=1984, author=George Orwell)

    // Lesson 7 - Singleton and Companion Object
    SingletonExample.showInstance()
    println(Choice.name)
    Choice.showDescription("pick")  // My favorite pick

    // Lesson 8 - Enum Classes
    val today = Day.MONDAY
    println("Today is $today")

    // Lesson 9 - Delegation
    val dog = Dog()
    dog.makeSound()  // Bark!

    // Part 2 - Pairs, Triples, Collections, Constants, Extension Functions, Higher-Order Functions
    pairAndTripleExamples()
    peopleCollection()
    println("The maximum age is $MAX_AGE")

    // Higher-Order Function Example
    val sum = performOperation(5, 3) { a, b -> a + b }
    println("Sum of 5 and 3 is: $sum")  // Output: Sum of 5 and 3 is: 8

    // Using Extension Function
    val greeting = "World".greet()
    println(greeting)  // Output: Hello, World!
}
