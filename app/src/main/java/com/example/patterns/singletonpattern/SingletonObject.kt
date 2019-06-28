package com.example.patterns.singletonpattern


object SingletonObject {

    private var instance: SingletonObject? = null

    fun getInstance(): SingletonObject {

        if (instance == null) {

            instance = SingletonObject
            return instance!!
        }

        return instance!!
    }

    //region Bir de fonksiyonla örnek kullanım:
    fun getNumber() : Int {

        return 5
    }
    //endregion
}
