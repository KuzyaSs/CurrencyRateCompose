package ru.ermakov.currencyratecompose.domain.repository

import ru.ermakov.currencyratecompose.domain.model.CurrencyRate
import ru.ermakov.currencyratecompose.domain.model.Result


interface CurrencyRateRepository {
    suspend fun getCurrencyRates(): Result<List<CurrencyRate>>
}