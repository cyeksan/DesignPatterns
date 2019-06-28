package com.example.patterns.visitorpattern.itemelement

import com.example.patterns.visitorpattern.visitor.IShoppingCardVisitor

interface ItemElement {

    fun accept(visitor: IShoppingCardVisitor) : Double?
}