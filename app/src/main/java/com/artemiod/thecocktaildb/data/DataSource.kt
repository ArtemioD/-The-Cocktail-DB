package com.artemiod.thecocktaildb.data

import com.artemiod.thecocktaildb.data.model.Cocktail
import com.artemiod.thecocktaildb.vo.Resource

class DataSource {

    private val generateCocktailsList = listOf(
        Cocktail("https://recetinas.com/wp-content/uploads/2018/10/coctel-margarita.jpg", "Margarita", "Con azucar, vodka y nueces"),
        Cocktail("https://www.labrujula24.com/wp-content/uploads/2022/05/fernet.jpg", "Fernet", "Fernet con coca y 2 hielos"),
        Cocktail("https://pbs.twimg.com/media/CERSHJwXIAATqjl.jpg", "Toro", "Toro con pritty"),
        Cocktail("https://64.media.tumblr.com/2a00c67fe2becf9e6704245c2432e625/tumblr_ny82d7tHAT1u916tro1_640.jpg", "Gancia", "Gancia con sprite")
    )

    fun getCocktailsList(): Resource<List<Cocktail>> = Resource.Success(generateCocktailsList)

}