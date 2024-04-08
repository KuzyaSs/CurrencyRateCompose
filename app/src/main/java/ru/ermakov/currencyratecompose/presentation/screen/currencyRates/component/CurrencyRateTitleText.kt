package ru.ermakov.currencyratecompose.presentation.screen.currencyRates.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import ru.ermakov.currencyratecompose.R
import ru.ermakov.currencyratecompose.presentation.theme.CurrencyRateComposeTheme

@Composable
fun CurrencyRateTitleText(text: String?, modifier: Modifier = Modifier) {
    Text(
        text = if (text != null)
            stringResource(id = R.string.currency_rate_with_date, text)
        else
            stringResource(id = R.string.app_name),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        modifier = modifier.fillMaxWidth()
    )
}

@Preview
@Composable
fun CurrencyRateTitleTextPreview() {
    CurrencyRateComposeTheme {
        Surface {
            CurrencyRateTitleText(text = null)
        }
    }
}