package com.artemiod.thecocktaildb.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.artemiod.thecocktaildb.R
import com.artemiod.thecocktaildb.data.model.Drink

class DetailFragment : Fragment() {

    private lateinit var cocktail: Drink

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            cocktail = it.getParcelable<Drink>("cocktail") ?: Drink()
            Log.d("TAG", "$cocktail")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

}