package ru.ermakov.currencyratecompose.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.ermakov.currencyratecompose.data.remote.api.CurrencyRateApi
import ru.ermakov.currencyratecompose.data.remote.dataSource.CurrencyRateRemoteDataSource
import ru.ermakov.currencyratecompose.data.remote.dataSource.CurrencyRateRemoteDataSourceImpl
import javax.inject.Singleton

private const val BASE_URL = "https://www.cbr-xml-daily.ru/"

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideCurrencyRateApi(retrofit: Retrofit): CurrencyRateApi {
        return retrofit.create(CurrencyRateApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCurrencyRateRemoteDataSource(currencyRateApi: CurrencyRateApi): CurrencyRateRemoteDataSource {
        return CurrencyRateRemoteDataSourceImpl(currencyRateApi = currencyRateApi)
    }
}