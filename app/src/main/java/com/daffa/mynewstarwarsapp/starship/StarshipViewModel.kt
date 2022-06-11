package com.daffa.mynewstarwarsapp.starship

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.daffa.core.domain.model.Starship
import com.daffa.core.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StarshipViewModel @Inject constructor(private val useCase: AppUseCase) : ViewModel() {
    val starship = useCase.getAllStarship().asLiveData()

    fun checkExistInFavorite(id: String) = useCase.checkExistInFavorite(id).asLiveData()

    fun setStarshipToFavorite(starship: Starship) {
        useCase.setStarshipToFavorite(starship)
    }

    fun deleteStarshipFromFavorite(starship: Starship) {
        useCase.deleteStarshipFromFavorite(starship)
    }
}