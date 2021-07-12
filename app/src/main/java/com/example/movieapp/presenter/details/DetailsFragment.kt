package com.example.movieapp.presenter.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.BASE_IMAGE_URL
import com.example.movieapp.databinding.FragmentDetailsBinding
import com.example.movieapp.presenter.details.model.MovieDetailsUiModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.NumberFormat
import java.util.*

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: DetailsFragmentArgs by navArgs()
    private val viewModel: DetailsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.movieDetails.observe(viewLifecycleOwner) { movieDetails ->
            if (movieDetails == null) {
                Toast.makeText(
                    context,
                    getString(R.string.fragment_details_unavailable_details),
                    Toast.LENGTH_LONG
                ).show()
                requireActivity().onBackPressed()
            } else {
                setMovieDetailsContent(movieDetails)
            }
        }
        viewModel.getMovieDetails(args.movieId)
    }

    private fun setMovieDetailsContent(movie: MovieDetailsUiModel) {
        Glide
            .with(requireContext())
            .load("${BASE_IMAGE_URL}${movie.backdropPath}")
            .placeholder(R.drawable.ic_movie_image_placeholder)
            .centerCrop()
            .into(binding.ivBackDrop)
        Glide
            .with(requireContext())
            .load("${BASE_IMAGE_URL}${movie.posterPath}")
            .placeholder(R.drawable.ic_movie_image_placeholder)
            .centerCrop()
            .into(binding.ivPoster)
        binding.tvTitle.text = movie.title
        binding.tvBudgetValue.text = NumberFormat.getNumberInstance(Locale.US).format(movie.budget)
        binding.tvOverviewDescription.text = movie.overview
        binding.tvReleaseDateValue.text = movie.releaseDate?.replace("-", "/")
        binding.tvStatusValue.text = movie.status
        binding.tvRevenueValue.text =
            NumberFormat.getNumberInstance(Locale.US).format(movie.revenue)
        binding.tvOriginalTitleValue.text = movie.originalTitle
        binding.tvRuntimeValue.text = movie.runtime.toString() + " min"
        binding.tvVoteAverageValue.text = movie.voteAverage.toString()
    }
}