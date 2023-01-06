package com.artemiod.thecocktaildb.domain

import com.artemiod.thecocktaildb.data.DataSource
import com.artemiod.thecocktaildb.data.model.Drink
import com.artemiod.thecocktaildb.vo.Resource

class RepositoryImplement(private val dataSource: DataSource) : Repository  {

    override suspend fun getCocktailsList(drinkName: String): Resource<List<Drink>> {
        return dataSource.getDrinkByName(drinkName)
    }
}