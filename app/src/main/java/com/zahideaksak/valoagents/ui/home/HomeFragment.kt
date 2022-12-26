package com.zahideaksak.valoagents.ui.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.zahideaksak.valoagents.databinding.FragmentHomeBinding
import com.zahideaksak.valoagents.utility.observeTextChanges
import com.zahideaksak.valoagents.utility.okWith
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.*

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeSearchTextChanges()

    }

    private fun observeSearchTextChanges() {
        binding.searchEditText.observeTextChanges()
            .filter { it okWith MINIMUM_SEARCH_LENGTH }
            .debounce(SEARCH_DEBOUNCE_TIME_IN_MILLISECONDS)
            .distinctUntilChanged()
            .onEach {
                viewModel.getValorantCardWithHealtPoints(it)
            }.launchIn(lifecycleScope)
    }

    companion object {
        private const val MINIMUM_SEARCH_LENGTH = 1
        private const val SEARCH_DEBOUNCE_TIME_IN_MILLISECONDS = 300L
    }

}