package com.artemiod.thecocktaildb.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Drink(
    @SerializedName("strDrinkThumb") val img: String = "",
    @SerializedName("strDrink") val name: String = "",
    @SerializedName("strInstructions") val description: String = "",
) : Parcelable

data class DrinkList(
    @SerializedName("drinks") val drinks: List<Drink>)
