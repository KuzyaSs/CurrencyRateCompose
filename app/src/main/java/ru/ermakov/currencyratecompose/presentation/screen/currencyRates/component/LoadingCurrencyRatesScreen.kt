package ru.ermakov.currencyratecompose.presentation.screen.currencyRates.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ermakov.currencyratecompose.presentation.theme.CurrencyRateComposeTheme

@Composable
fun LoadingCurrencyRatesScreen(lastUpdateDate: String?, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        CurrencyRateTitleText(
            text = lastUpdateDate,
            modifier = Modifier.padding(all = 16.dp)
        )
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
        }
    }
}

@Preview
@Composable
fun LoadingCurrencyRatesScreenPreview() {
    CurrencyRateComposeTheme {
        Surface {
            LoadingCurrencyRatesScreen(lastUpdateDate = "12:30:45, 1 April")
        }
    }
}