package ru.ermakov.currencyratecompose.domain.model

data class CurrencyRate(
    val charCode: String,
    val name: String,
    val rate: Double,
    val previousRate: Double
)