package ru.ermakov.currencyratecompose.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import ru.ermakov.currencyratecompose.data.remote.model.RemoteCurrencyRateResponse

interface CurrencyRateApi {
    @GET("daily_json.js")
    suspend fun getCurrencyRates(): Response<RemoteCurrencyRateResponse>
}