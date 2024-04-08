package ru.ermakov.currencyratecompose.presentation.screen.currencyRates

import ru.ermakov.currencyratecompose.domain.model.CurrencyRate

data class CurrencyRatesUiState(
    val currencyRates: List<CurrencyRate> = emptyList(),
    val lastUpdateDate: String? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false
)