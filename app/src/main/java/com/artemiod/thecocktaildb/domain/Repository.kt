package com.artemiod.thecocktaildb.domain

import com.artemiod.thecocktaildb.data.model.Cocktail
import com.artemiod.thecocktaildb.vo.Resource

interface Repository {
    fun getCocktailsList(): Resource<List<Cocktail>>
}