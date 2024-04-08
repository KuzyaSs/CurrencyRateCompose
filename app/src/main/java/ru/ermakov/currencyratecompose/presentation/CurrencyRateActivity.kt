package ru.ermakov.currencyratecompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import ru.ermakov.currencyratecompose.presentation.screen.currencyRates.CurrencyRatesScreen
import ru.ermakov.currencyratecompose.presentation.screen.currencyRates.CurrencyRatesViewModel
import ru.ermakov.currencyratecompose.presentation.theme.CurrencyRateComposeTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurrencyRateComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val currencyRatesViewModel = hiltViewModel<CurrencyRatesViewModel>()
                    val state by currencyRatesViewModel.state.collectAsState()
                    CurrencyRatesScreen(
                        state = state,
                        onTryAgainButtonClick = { currencyRatesViewModel.loadCurrencyRates() }
                    )
                }
            }
        }
    }
}