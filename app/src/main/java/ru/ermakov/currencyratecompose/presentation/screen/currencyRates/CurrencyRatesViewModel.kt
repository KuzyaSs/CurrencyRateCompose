package ru.ermakov.currencyratecompose.presentation.screen.currencyRates

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.ermakov.currencyratecompose.domain.repository.CurrencyRateRepository
import ru.ermakov.currencyratecompose.domain.useCase.GetFormattedCurrentDateUseCase
import javax.inject.Inject
import ru.ermakov.currencyratecompose.domain.model.Result

// A delay that allows the user to see loading without quickly changing the state.
private const val LOADING_DELAY = 500L
private const val REFRESH_INTERVAL_DELAY = 7_000L

@HiltViewModel
class CurrencyRatesViewModel @Inject constructor(
    private val currencyRateRepository: CurrencyRateRepository,
    private val getFormattedCurrentDateUseCase: GetFormattedCurrentDateUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(CurrencyRatesUiState())
    val state: StateFlow<CurrencyRatesUiState> = _state.asStateFlow()

    private var loadCurrencyRatesJob: Job? = null

    init {
        loadCurrencyRates()
    }

    fun loadCurrencyRates() {
        loadCurrencyRatesJob?.cancel()
        loadCurrencyRatesJob = viewModelScope.launch(Dispatchers.IO) {
            while (true) {
                _state.value = _state.value.copy(isLoading = true, isError = false)
                delay(LOADING_DELAY)
                val currencyRatesResult = currencyRateRepository.getCurrencyRates()
                when (currencyRatesResult) {
                    is Result.Success -> {
                        _state.value = _state.value.copy(
                            currencyRates = currencyRatesResult.data,
                            lastUpdateDate = getFormattedCurrentDateUseCase(),
                            isLoading = false,
                            isError = false
                        )
                    }

                    is Result.Error -> {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            isError = true,
                        )
                    }
                }
                delay(REFRESH_INTERVAL_DELAY)
            }
        }
    }

    fun clearError() {
        _state.value = _state.value.copy(isError = false)
    }
}