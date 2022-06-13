package com.daffa.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.daffa.core.domain.usecase.AppUseCase

class FavoriteViewModel(useCase: AppUseCase) : ViewModel() {
    val favorite = useCase.getAllFavorite().asLiveData()
}