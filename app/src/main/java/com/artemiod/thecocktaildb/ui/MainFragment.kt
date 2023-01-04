package com.artemiod.thecocktaildb.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.artemiod.thecocktaildb.R
import com.artemiod.thecocktaildb.data.DataSource
import com.artemiod.thecocktaildb.data.model.Cocktail
import com.artemiod.thecocktaildb.databinding.FragmentMainBinding
import com.artemiod.thecocktaildb.domain.RepositoryImplement
import com.artemiod.thecocktaildb.ui.viewmodel.MainViewModel
import com.artemiod.thecocktaildb.ui.viewmodel.VMFactory
import com.artemiod.thecocktaildb.vo.Resource


class MainFragment : Fragment(), OnCocktailClickListener {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<MainViewModel> { VMFactory(RepositoryImplement(DataSource())) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        viewModel.fetchCocktailsList.observe(viewLifecycleOwner, Observer {
            when(it) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rvCocktails.adapter = CocktailAdapter(it.data, this)
                }
                is Resource.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Ocurrio un error al traer los datos ${it.exception}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun setupRecyclerView() {
        //binding.rvCocktails.layoutManager = LinearLayoutManager(requireContext())
        //binding.rvCocktails.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    }

    override fun onCocktailClick(cocktail: Cocktail) {
        val bundle = Bundle()
        bundle.putParcelable("cocktail", cocktail)
        findNavController().navigate(R.id.detailFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}