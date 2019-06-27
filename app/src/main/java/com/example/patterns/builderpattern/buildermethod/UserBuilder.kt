package com.example.patterns.builderpattern.buildermethod

class UserBuilder {

    var user: UserObject? = null

    init {

        user = UserObject()
    }

    fun setUserName(name: String): UserBuilder {

        user?.name = name
        return this

    }

    fun setUserSurname(surname: String): UserBuilder {

        user?.surname = surname
        return this

    }

    fun setUserAge(age: Int): UserBuilder {

        user?.age = age
        return this

    }

    fun setUserHeight(height: Double): UserBuilder {

        user?.height = height
        return this

    }

    fun setUserWeight(weight: Double): UserBuilder {

        user?.weight = weight
        return this

    }

    fun build(): UserObject {

        return user!!
    }

}