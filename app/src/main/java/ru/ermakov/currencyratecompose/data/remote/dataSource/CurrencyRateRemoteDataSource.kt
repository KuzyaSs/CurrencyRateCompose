package ru.ermakov.currencyratecompose.data.remote.dataSource

import ru.ermakov.currencyratecompose.domain.model.CurrencyRate
import ru.ermakov.currencyratecompose.domain.model.Result

interface CurrencyRateRemoteDataSource {
    suspend fun getCurrencyRates(): Result<List<CurrencyRate>>
}