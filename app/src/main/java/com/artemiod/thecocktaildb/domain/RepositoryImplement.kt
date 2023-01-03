package com.artemiod.thecocktaildb.domain

import com.artemiod.thecocktaildb.data.DataSource
import com.artemiod.thecocktaildb.data.model.Cocktail
import com.artemiod.thecocktaildb.vo.Resource

class RepositoryImplement(private val dataSource: DataSource) : Repository  {

    override fun getCocktailsList(): Resource<List<Cocktail>> {
        return dataSource.getCocktailsList()
    }
}