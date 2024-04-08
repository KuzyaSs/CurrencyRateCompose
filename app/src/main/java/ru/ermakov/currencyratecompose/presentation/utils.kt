package ru.ermakov.currencyratecompose.presentation

fun Double.normalizeRate(): Double {
    return String.format("%.3f", this).toDouble()
}