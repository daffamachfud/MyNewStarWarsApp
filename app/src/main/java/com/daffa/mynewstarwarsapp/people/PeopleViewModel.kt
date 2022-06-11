package com.daffa.mynewstarwarsapp.people

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.daffa.core.domain.model.People
import com.daffa.core.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel@Inject constructor(private val useCase: AppUseCase) : ViewModel() {
    val people = useCase.getAllPeople().asLiveData()

    fun checkExistInFavorite(id:String) = useCase.checkExistInFavorite(id).asLiveData()

    fun setPeopleToFavorite(people: People){
        useCase.setPeopleToFavorite(people)
    }

    fun deletePeopleFromFavorite(people: People){
        useCase.deletePeopleFromFavorite(people)
    }

}