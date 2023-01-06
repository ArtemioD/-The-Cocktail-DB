package com.artemiod.thecocktaildb.data

import com.artemiod.thecocktaildb.data.model.Drink
import com.artemiod.thecocktaildb.vo.Resource
import com.artemiod.thecocktaildb.vo.RetrofitClient

class DataSource {

    suspend fun getDrinkByName(drinkName: String): Resource<List<Drink>> {
        return Resource.Success(RetrofitClient.webService.getDrinkByName(drinkName).drinks)
    }

/* no nesetito mas es data local

    private val generateCocktailsList = listOf(
        Drink("https://recetinas.com/wp-content/uploads/2018/10/coctel-margarita.jpg", "Margarita", "Con azucar, vodka y nueces"),
        Drink("https://www.labrujula24.com/wp-content/uploads/2022/05/fernet.jpg", "Fernet", "Fernet con coca y 2 hielos"),
        Drink("https://pbs.twimg.com/media/CERSHJwXIAATqjl.jpg", "Toro", "Toro con pritty"),
        Drink("https://64.media.tumblr.com/2a00c67fe2becf9e6704245c2432e625/tumblr_ny82d7tHAT1u916tro1_640.jpg", "Gancia", "Gancia con sprite")
    )

    fun getCocktailsList(): Resource<List<Drink>> = Resource.Success(generateCocktailsList)
*/
}