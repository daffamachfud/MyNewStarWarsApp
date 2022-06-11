package com.daffa.mynewstarwarsapp.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.daffa.core.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(useCase: AppUseCase) : ViewModel() {
    val favorite = useCase.getAllFavorite().asLiveData()
}