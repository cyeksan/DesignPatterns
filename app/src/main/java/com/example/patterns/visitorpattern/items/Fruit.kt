package com.example.patterns.visitorpattern.items

import com.example.patterns.visitorpattern.visitor.IShoppingCardVisitor
import com.example.patterns.visitorpattern.itemelement.ItemElement

class Fruit(
    pricePerWeight: Double?,
    name: String?,
    weight: Double?
): ItemElement {

    private var pricePerWeight: Double? = null
    private var name: String? = null
    private var weight: Double? = null

    init {

        this.pricePerWeight = pricePerWeight
        this.name = name
        this.weight = weight
    }

    fun getFruitPrice() : Double? {

        return pricePerWeight
    }
    fun getFruitName() : String? {

        return name
    }

    fun getFruitWeight() : Double? {

        return weight
    }

    override fun accept(visitor: IShoppingCardVisitor) : Double? {

        return visitor.visit(this)
    }

}
