package ru.ermakov.currencyratecompose.data.repository

import ru.ermakov.currencyratecompose.data.remote.dataSource.CurrencyRateRemoteDataSource
import ru.ermakov.currencyratecompose.domain.model.CurrencyRate
import ru.ermakov.currencyratecompose.domain.model.Result
import ru.ermakov.currencyratecompose.domain.repository.CurrencyRateRepository


class CurrencyRateRepositoryImpl(
    private val currencyRateRemoteDataSource: CurrencyRateRemoteDataSource
) : CurrencyRateRepository {
    override suspend fun getCurrencyRates(): Result<List<CurrencyRate>> {
        return currencyRateRemoteDataSource.getCurrencyRates()
    }
}