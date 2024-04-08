package ru.ermakov.currencyratecompose.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.ermakov.currencyratecompose.data.remote.dataSource.CurrencyRateRemoteDataSource
import ru.ermakov.currencyratecompose.data.repository.CurrencyRateRepositoryImpl
import ru.ermakov.currencyratecompose.domain.repository.CurrencyRateRepository

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun provideCurrencyRateRepository(
        currencyRateRemoteDataSource: CurrencyRateRemoteDataSource
    ): CurrencyRateRepository {
        return CurrencyRateRepositoryImpl(currencyRateRemoteDataSource = currencyRateRemoteDataSource)
    }
}