package com.example.patterns.visitorpattern.visitor

import com.example.patterns.visitorpattern.items.Book
import com.example.patterns.visitorpattern.items.Fruit

interface IShoppingCardVisitor {

    fun visit(book: Book) : Double?
    fun visit(fruit: Fruit) : Double?
}