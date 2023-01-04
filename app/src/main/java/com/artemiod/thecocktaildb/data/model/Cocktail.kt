package com.artemiod.thecocktaildb.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cocktail(
    val img: String = "",
    val name: String = "",
    val description: String = "",
) : Parcelable
