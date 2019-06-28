package com.example.patterns.visitorpattern.impl

import android.util.Log
import com.example.patterns.visitorpattern.items.Book
import com.example.patterns.visitorpattern.items.Fruit
import com.example.patterns.visitorpattern.visitor.IShoppingCardVisitor

class ShoppingCardImpl : IShoppingCardVisitor {

    override fun visit(book: Book) : Double? {

        Log.v("visitorPatternResult", "Book ISBN: ${book.getIsbnNumber()}, Book Cost: ${book.getBookPrice()}")

        return if(book.getBookPrice()!! > 50) {

            (book.getBookPrice()!! - 5)

        } else {

            book.getBookPrice()!!
        }

    }

    override fun visit(fruit: Fruit) : Double? {

        val fruitCost = fruit.getFruitPrice()!!*fruit.getFruitWeight()!!

        Log.v("visitorPatternResult", "${fruit.getFruitName()} Cost: $fruitCost")

        return fruitCost

    }
}