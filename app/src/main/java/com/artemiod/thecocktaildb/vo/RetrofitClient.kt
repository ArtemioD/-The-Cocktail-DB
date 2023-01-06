package com.artemiod.thecocktaildb.vo

import com.artemiod.thecocktaildb.domain.WebService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"

    val webService by lazy {
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(WebService::class.java)
    }
}