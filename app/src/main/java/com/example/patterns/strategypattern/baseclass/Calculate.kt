package com.example.patterns.strategypattern.baseclass

import com.example.patterns.strategypattern.strategyinterface.Strategy

class Calculate(private var num1: Int, private var num2: Int) {

    fun executeCalculation(strategy: Strategy): Int {

        return strategy.doOperation(num1, num2)
    }
}