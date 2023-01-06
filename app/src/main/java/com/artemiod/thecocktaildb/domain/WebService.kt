package com.artemiod.thecocktaildb.domain

import com.artemiod.thecocktaildb.data.model.DrinkList
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    // no hace fanlta poner el nobre, con Query eso automaticamente
    @GET("search.php?s=")
    suspend fun getDrinkByName(@Query("drinkName") drinkName: String): DrinkList

}