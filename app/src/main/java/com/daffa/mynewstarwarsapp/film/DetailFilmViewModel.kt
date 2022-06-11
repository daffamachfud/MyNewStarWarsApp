package com.daffa.mynewstarwarsapp.film

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.daffa.core.domain.model.Film
import com.daffa.core.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailFilmViewModel @Inject constructor(private val useCase: AppUseCase) : ViewModel() {

    fun checkExistInFavorite(id: String) = useCase.checkExistInFavorite(id).asLiveData()

    fun setFilmToFavorite(film: Film) {
        useCase.setFilmToFavorite(film)
    }

    fun deleteFilmFromFavorite(film: Film) {
        useCase.deleteFilmFromFavorite(film)
    }
}