package com.racso.rickandmorty.ui.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.racso.basiccodelabcompose.data.models.Result
import com.racso.rickandmorty.domain.GetCharactersListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val getCharactersListUseCase: GetCharactersListUseCase) :
    ViewModel() {

        val characters: MutableLiveData<List<Result>> = MutableLiveData(emptyList<Result>())

        init {
            viewModelScope.launch {
                characters.value = getCharactersListUseCase()
            }
        }
}