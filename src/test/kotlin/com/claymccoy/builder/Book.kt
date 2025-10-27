package com.claymccoy.builder

data class Book(val title: String,
                val author: String,
                val yearPublished: Int,
                val description: String? = null)

fun main() {
    val book = Book(
        title = "Effective Java",
        author = "Joshua Bloch",
        yearPublished = 2001
    )
    println(book)

    val secondEdition = book.copy(yearPublished = 2008, description = "Second Edition")
    println(secondEdition)
}
