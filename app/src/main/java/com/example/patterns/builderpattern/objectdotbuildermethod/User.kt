package com.example.patterns.builderpattern.objectdotbuildermethod

class User {

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

    class Builder {

        var user: User? = null

        init {

            user = User()
        }

        fun setUserName(name: String): Builder {

            user?.name = name
            return this

        }

        fun setUserSurname(surname: String): Builder {

            user?.surname = surname
            return this

        }

        fun setUserAge(age: Int): Builder {

            user?.age = age
            return this

        }

        fun setUserHeight(height: Double): Builder {

            user?.height = height
            return this

        }

        fun setUserWeight(weight: Double): Builder {

            user?.weight = weight
            return this

        }

        fun build(): User {

            return user!!
        }
    }

}