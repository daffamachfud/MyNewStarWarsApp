package com.daffa.mynewstarwarsapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.daffa.mynewstarwarsapp.core.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(useCase: AppUseCase) : ViewModel() {
    val film = useCase.getAllFilm().asLiveData()
}