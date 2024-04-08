package ru.ermakov.currencyratecompose.presentation.screen.currencyRates.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ermakov.currencyratecompose.domain.model.CurrencyRate
import ru.ermakov.currencyratecompose.presentation.theme.CurrencyRateComposeTheme

@Composable
fun SuccessfulCurrencyRatesScreen(
    lastUpdateDate: String,
    currencyRates: List<CurrencyRate>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        CurrencyRateTitleText(
            text = lastUpdateDate,
            modifier = Modifier.padding(all = 16.dp)
        )
        CurrencyRateList(currencyRates = currencyRates)
    }
}

@Preview
@Composable
fun SuccessfulCurrencyRatesScreenPreview() {
    CurrencyRateComposeTheme {
        Surface {
            SuccessfulCurrencyRatesScreen(
                lastUpdateDate = "12:30:45, 1 April",
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
                    )
                )
            )
        }
    }
}