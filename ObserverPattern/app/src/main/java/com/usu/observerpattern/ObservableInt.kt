package com.usu.observerpattern

class ObservableInt(private var value: Int = 0) {

    val observers = mutableListOf<(Int) -> Unit>()

    fun observe(observer: (Int) -> Unit) {
        observers.add(observer)
    }

    fun setValue(value: Int) {
        this.value = value
        observers.forEach {
            it(value)
        }
    }

    fun getValue(): Int {
        return value
    }

}