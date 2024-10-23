// Akhil Yadati
// KotlinLesson2-Code: Complete Codelab Tasks

import java.util.*

// Main function
fun main() {
    // 1. Basic println assignment
    val isUnit = println("This is an expression")
    println(isUnit)  // Output: kotlin.Unit

    // 2. Temperature check using if-else expression
    val temperature = 10
    val isHot = if (temperature > 50) true else false
    println(isHot)

    // 3. Call functions for fish feeding and water change
    feedTheFish()

    // 4. Demonstrate default and named parameters in swim function
    swim()               // Uses default speed
    swim("slow")         // Positional argument
    swim(speed = "fast") // Named parameter

    // 5. Filtering aquarium decorations
    filterDecorations()

    // 6. Demonstrating lambdas and higher-order functions
    val dirtyLevel = 20
    val waterFilter = { dirty: Int -> dirty / 2 }
    println(waterFilter(dirtyLevel))

    // 7. Higher-order function with updateDirty()
    println(updateDirty(30, waterFilter))

    // 8. Pass a named function to higher-order function
    println(updateDirty(15, ::increaseDirty))

    // Lambda with last parameter call syntax
    var dirtyLevel2 = 19
    dirtyLevel2 = updateDirty(dirtyLevel2) { dirtyLevel2 -> dirtyLevel2 + 23 }
    println(dirtyLevel2)
}

// Task 3: Feed the fish with random day and food
fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

// Task 3: Get a random day of the week
fun randomDay(): String {
    val week = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

// Task 3: Determine fish food based on the day
fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}

// Task 6: Check if water needs to be changed
fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        temperature > 30 -> true
        dirty > 30 -> true
        day == "Sunday" -> true
        else -> false
    }
}

// Task 4: Swim function with default value
fun swim(speed: String = "fast") {
    println("swimming $speed")
}

// Task 5: Filtering aquarium decorations
fun filterDecorations() {
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    println(decorations.filter { it[0] == 'p' })  // Filter decorations starting with 'p'

    // Lazy evaluation using Sequence
    val eager = decorations.filter { it[0] == 'p' }
    println("eager: $eager")

    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")

    // Force evaluation with toList
    val newList = filtered.toList()
    println("new list: $newList")

    // Lazy map operation
    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }
    println("first: ${lazyMap.first()}")
    println("all: ${lazyMap.toList()}")
}

// Task 6: Lambda and higher-order functions
fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

// Task 7: Higher-order function with a named function
fun increaseDirty(start: Int) = start + 1
