package com.artemiod.thecocktaildb.domain

import com.artemiod.thecocktaildb.data.model.Drink
import com.artemiod.thecocktaildb.vo.Resource

interface Repository {
    suspend fun getCocktailsList(drinkName: String): Resource<List<Drink>>
}