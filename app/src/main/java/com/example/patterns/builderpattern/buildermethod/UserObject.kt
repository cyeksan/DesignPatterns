package com.example.patterns.builderpattern.buildermethod

class UserObject {

    var name: String? = null
    var surname: String? = null
    var age: Int? = null
    var height: Double? = null
    var weight: Double? = null

    fun getUserName(): String {

        return name!!

    }

    fun getUserSurname(): String {

        return surname!!

    }


    fun getUserAge(): Int {

        return age!!

    }


    fun getUserHeight(): Double {

        return height!!

    }

    fun getUserWeight(): Double {

        return weight!!

    }

}