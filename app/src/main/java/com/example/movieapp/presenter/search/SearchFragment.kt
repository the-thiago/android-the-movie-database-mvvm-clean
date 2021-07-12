package com.example.movieapp.presenter.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentSearchBinding
import com.example.movieapp.presenter.MovieAdapter
import com.example.movieapp.presenter.nowplaying.model.MovieUiModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SearchViewModel by viewModel()
    private val adapter by lazy { MovieAdapter(::clickItem) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            adapter = this@SearchFragment.adapter
        }
        viewModel.movies.observe(viewLifecycleOwner) {
            if (it.isNullOrEmpty()) {
                binding.tvSearchResultStatus.text =
                    getString(R.string.fragment_search_no_movie_found)
                binding.tvSearchResultStatus.visibility = View.VISIBLE
            } else {
                binding.tvSearchResultStatus.visibility = View.GONE
            }
            this@SearchFragment.adapter.submitItems(it)
        }
        binding.etSearchField.doOnTextChanged { text, _, _, _ ->
            viewModel.searchMovies(text.toString())
        }
    }

    private fun clickItem(movieUiModel: MovieUiModel) {
        findNavController().navigate(
            SearchFragmentDirections.actionSearchFragmentToDetailsFragment(
                movieUiModel.id
            )
        )
    }
}