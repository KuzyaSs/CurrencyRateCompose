package ru.ermakov.currencyratecompose.presentation.screen.currencyRates.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ermakov.currencyratecompose.domain.model.CurrencyRate
import ru.ermakov.currencyratecompose.presentation.screen.currencyRates.MockData
import ru.ermakov.currencyratecompose.presentation.theme.CurrencyRateComposeTheme

@Composable
fun CurrencyRateList(currencyRates: List<CurrencyRate>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(all = 16.dp)
    ) {
        items(currencyRates) { currencyRate ->
            CurrencyRateItem(currencyRate = currencyRate)
        }
    }
}

@Preview
@Composable
fun CurrencyRateListPreview() {
    CurrencyRateComposeTheme {
        Surface {
            CurrencyRateList(currencyRates = MockData.state.currencyRates)
        }
    }
}