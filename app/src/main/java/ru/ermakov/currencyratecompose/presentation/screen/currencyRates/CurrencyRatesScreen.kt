package ru.ermakov.currencyratecompose.presentation.screen.currencyRates

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.ermakov.currencyratecompose.R
import ru.ermakov.currencyratecompose.domain.model.CurrencyRate
import ru.ermakov.currencyratecompose.presentation.screen.currencyRates.component.ErrorCurrencyRatesScreen
import ru.ermakov.currencyratecompose.presentation.screen.currencyRates.component.LoadingCurrencyRatesScreen
import ru.ermakov.currencyratecompose.presentation.screen.currencyRates.component.SuccessfulCurrencyRatesScreen
import ru.ermakov.currencyratecompose.presentation.theme.CurrencyRateComposeTheme

@Composable
fun CurrencyRatesScreen(
    state: CurrencyRatesUiState,
    onTryAgainButtonClick: () -> Unit,
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val errorMessage = stringResource(id = R.string.connection_failure_exception)

    if (state.isError && state.currencyRates.isNotEmpty()) {
        LaunchedEffect(key1 = snackbarHostState) {
            snackbarHostState.showSnackbar(message = errorMessage)
        }
    }

    Scaffold(snackbarHost = {
        SnackbarHost(hostState = snackbarHostState)
    }) { contentPadding ->
        when {
            state.currencyRates.isNotEmpty() && state.lastUpdateDate != null -> {
                SuccessfulCurrencyRatesScreen(
                    lastUpdateDate = state.lastUpdateDate,
                    currencyRates = state.currencyRates,
                    modifier = Modifier.padding(contentPadding)
                )
            }

            state.isLoading && state.currencyRates.isEmpty() -> {
                LoadingCurrencyRatesScreen(
                    lastUpdateDate = state.lastUpdateDate,
                    modifier = Modifier.padding(contentPadding)
                )
            }

            state.isError && state.currencyRates.isEmpty() -> {
                ErrorCurrencyRatesScreen(
                    lastUpdateDate = state.lastUpdateDate,
                    onTryAgainButtonClick = {
                        onTryAgainButtonClick()
                    },
                    modifier = Modifier.padding(contentPadding)
                )
            }
        }
    }
}


@Preview(apiLevel = 33, showSystemUi = true, showBackground = true)
@Composable
fun CurrencyRatesScreenPreview() {
    CurrencyRateComposeTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            CurrencyRatesScreen(state = MockData.state, onTryAgainButtonClick = {})
        }
    }
}

object MockData {
    val state = CurrencyRatesUiState(
        currencyRates = listOf(
            CurrencyRate(
                "USD",
                "Доллар США",
                100.0,
                90.0
            ),
            CurrencyRate(
                "USD",
                "Доллар США",
                100.0,
                90.0
            ),
            CurrencyRate(
                "USD",
                "Доллар США",
                100.0,
                90.0
            ),
        ),
        lastUpdateDate = "12:30:45, 1 April",
        isError = true
    )
}