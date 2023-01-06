package com.artemiod.thecocktaildb.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artemiod.thecocktaildb.R
import com.artemiod.thecocktaildb.data.model.Drink
import com.artemiod.thecocktaildb.databinding.ItemListBinding
import com.bumptech.glide.Glide

// interface para hacer click
interface OnCocktailClickListener {
    fun onCocktailClick(cocktail: Drink)
}

class CocktailAdapter(
    private val cocktailsList: List<Drink>,
    private val itemClickListener: OnCocktailClickListener,
) : RecyclerView.Adapter<CocktailAdapter.ViewHolder>() {

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemListBinding.bind(view)

        fun bind(cocktail: Drink) {
            Glide.with(view.context).load(cocktail.img).into(binding.ivImgCocktail)
            binding.tvName.text = cocktail.name
            binding.tvDescription.text = cocktail.description

            // para cuando hacemos click en item
            view.setOnClickListener {
                itemClickListener.onCocktailClick(cocktail)
            }
        }
    }

    // Creamos la vista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    // cuales la posision de cala item con los parametros
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = cocktailsList[position]
        holder.bind(item)
    }

    // cantidad de items
    override fun getItemCount(): Int = cocktailsList.size
}