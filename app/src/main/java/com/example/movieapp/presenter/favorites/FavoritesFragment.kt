package com.example.movieapp.presenter.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.movieapp.databinding.FragmentFavoritesBinding
import com.example.movieapp.presenter.MovieAdapter
import com.example.movieapp.presenter.nowplaying.model.MovieUiModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoritesFragment : Fragment() {

    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FavoritesViewModel by viewModel()
    private val adapter by lazy { MovieAdapter(::clickItem) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = this.adapter
        viewModel.favoriteMovies.observe(viewLifecycleOwner) {
            if (it.isNullOrEmpty()) {
                binding.tvNoFavoriteMovieText.visibility = View.VISIBLE
            } else {
                this@FavoritesFragment.adapter.submitItems(it)
            }
        }
        viewModel.getLocalMovies()
    }

    private fun clickItem(movieUiModel: MovieUiModel) {
        findNavController().navigate(
            FavoritesFragmentDirections.actionFavoritesFragmentToDetailsFragment(
                movieUiModel.id
            )
        )
    }
}