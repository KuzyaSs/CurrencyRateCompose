package ru.ermakov.currencyratecompose.data.remote.model

import com.google.gson.annotations.SerializedName

data class RemoteCurrencyRateResponse(
    @SerializedName("Valute")
    val remoteCurrencyRates: Map<String, RemoteCurrencyRate>
)