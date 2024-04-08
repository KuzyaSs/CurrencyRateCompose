package ru.ermakov.currencyratecompose.presentation.screen.currencyRates.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.ermakov.currencyratecompose.R
import ru.ermakov.currencyratecompose.domain.model.CurrencyRate
import ru.ermakov.currencyratecompose.presentation.normalizeRate
import ru.ermakov.currencyratecompose.presentation.theme.CurrencyRateComposeTheme

@Composable
fun CurrencyRateItem(currencyRate: CurrencyRate, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1.0f)) {
            Text(
                text = currencyRate.charCode,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
            )
            Text(
                text = currencyRate.name,
                fontSize = 14.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Text(
            text = stringResource(
                id = R.string.currency_rate,
                currencyRate.rate.normalizeRate()
            ),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 16.dp)
        )

        val rateChange = currencyRate.rate - currencyRate.previousRate
        Text(
            text = if (rateChange >= 0)
                String.format("(+%s)", rateChange.normalizeRate())
            else
                String.format("(%s)", rateChange.normalizeRate()),
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview
@Composable
fun CurrencyRateItemPreview() {
    CurrencyRateComposeTheme {
        Surface {
            CurrencyRateItem(
                currencyRate = CurrencyRate(
                    "USD",
                    "Доллар США",
                    97.0,
                    95.0
                )
            )
        }
    }
}