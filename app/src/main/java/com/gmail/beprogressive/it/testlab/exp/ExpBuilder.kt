package com.gmail.beprogressive.it.testlab.exp

object ExpBuilder {
    fun start() {
        val burger = VegaBurger.Builder()
            .bread("Сладкая булочка")
            .cutlet("Kaufland")
            .cheese("Чеддер")
            .salad("Ромен")
            .sauce("Барбекю")
            .build()
        burger.eat()
    }

    class VegaBurger private constructor(
        bread: String = "",
        cutlet: String = "",
        cheese: String = "",
        salad: String = "",
        sauce: String = "",
    ) {

        fun eat() {}

        class Builder {
            private var bread: String = ""
//        var cheese: String = ""
//            private set
//        var salad: String = ""
//            private set
//        var sauce: String = ""
//            private set

            fun bread(bread: String = "") = Bread(bread)

            fun build() = VegaBurger()

            class Bread(private val bread: String) {
                fun cutlet(cutlet: String) = Cutlet(bread, cutlet)
                fun build() = VegaBurger(bread)
            }

            class Cutlet(private val bread: String, private val cutlet: String) {
                fun cheese(cheese: String) = Cheese(bread, cutlet, cheese)
                fun build() = VegaBurger(bread, cutlet)
            }

            class Cheese(
                private val bread: String,
                private val cutlet: String,
                private val cheese: String
            ) {
                fun salad(salad: String) = Salad(bread, cutlet, cheese, salad)
                fun build() = VegaBurger(bread, cutlet, cheese)
            }

            class Salad(
                private val bread: String,
                private val cutlet: String,
                private val cheese: String,
                private val salad: String
            ) {
                fun sauce(sauce: String) = Sauce(bread, cutlet, cheese, salad, sauce)
                fun build() = VegaBurger(bread, cutlet, cheese, salad)
            }

            class Sauce(
                private val bread: String,
                private val cutlet: String,
                private val cheese: String,
                private val salad: String,
                private val sauce: String
            ) {
                fun build() = VegaBurger(bread, cutlet, cheese, salad, sauce)
            }
        }

    }
}