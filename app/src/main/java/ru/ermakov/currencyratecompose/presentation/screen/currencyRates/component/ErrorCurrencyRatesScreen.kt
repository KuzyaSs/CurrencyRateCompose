package ru.ermakov.currencyratecompose.presentation.screen.currencyRates.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ermakov.currencyratecompose.R
import ru.ermakov.currencyratecompose.presentation.theme.CurrencyRateComposeTheme

@Composable
fun ErrorCurrencyRatesScreen(
    lastUpdateDate: String?,
    onTryAgainButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        CurrencyRateTitleText(
            text = lastUpdateDate,
            modifier = Modifier.padding(all = 16.dp)
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                imageVector = Icons.Rounded.Warning,
                contentDescription = null,
                modifier = Modifier.size(100.dp),
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onBackground)
            )
            Text(
                text = stringResource(id = R.string.connection_failure_exception),
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Button(
                onClick = { onTryAgainButtonClick() }
            ) {
                Text(text = stringResource(id = R.string.try_again))
            }
        }
    }
}

@Preview()
@Composable
fun ErrorCurrencyRatesScreenPreview() {
    CurrencyRateComposeTheme {
        Surface {
            ErrorCurrencyRatesScreen(
                lastUpdateDate = "12:30:45, 1 April",
                onTryAgainButtonClick = {}
            )
        }
    }
}