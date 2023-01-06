package com.artemiod.thecocktaildb.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.artemiod.thecocktaildb.domain.Repository
import com.artemiod.thecocktaildb.vo.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val repository: Repository) : ViewModel() {

    val fetchCocktailsList = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repository.getCocktailsList("margarita"))
        }catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }
}