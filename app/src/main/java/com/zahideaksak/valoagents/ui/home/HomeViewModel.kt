package com.zahideaksak.valoagents.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zahideaksak.valoagents.R
import com.zahideaksak.valoagents.data.NetworkResponseState
import com.zahideaksak.valoagents.domain.GetAgentWithHealthPointUseCase
import com.zahideaksak.valoagents.domain.ValorantEntity
import com.zahideaksak.valoagents.domain.ValorantListMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAgentWithHealthPointUseCase: GetAgentWithHealthPointUseCase,
    private val valorantListMapper: ValorantListMapper<ValorantEntity, HomeUiData>,
) : ViewModel() {
    // Backing field § encapsulation

    private val _valorantHomeUiState = MutableLiveData<HomeUiState>()
    val valorantHomeUiState: LiveData<HomeUiState> get() = _valorantHomeUiState

    fun getValorantCardWithHealtPoints(healthPoint: String) {
        viewModelScope.launch {
            getAgentWithHealthPointUseCase(healthPoint).onEach {
                when (it) {
                    is NetworkResponseState.Error -> {
                        // _pokeHomeUiState.value = ** MainThread
                        _valorantHomeUiState.postValue(HomeUiState.Error(R.string.error))
                    }
                    NetworkResponseState.Loading -> {
                        _valorantHomeUiState.postValue((HomeUiState.Loading))
                    }
                    is NetworkResponseState.Success -> {
                        _valorantHomeUiState.postValue(HomeUiState.Success(valorantListMapper.map(it.result)))
                    }
                }
            }
        }
    }
}