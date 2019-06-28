package com.example.patterns.visitorpattern.items

import com.example.patterns.visitorpattern.visitor.IShoppingCardVisitor
import com.example.patterns.visitorpattern.itemelement.ItemElement

class Book(
    price: Double?,
    isbnNumber: Int?
) : ItemElement {

    private var price: Double? = null
    private var isbnNumber: Int? = null

    init {

        this.price = price
        this.isbnNumber = isbnNumber
    }

    fun getBookPrice(): Double? {

        return price
    }

    fun getIsbnNumber(): Int? {

        return isbnNumber
    }

    override fun accept(visitor: IShoppingCardVisitor): Double? {

        return visitor.visit(this)
    }

}
