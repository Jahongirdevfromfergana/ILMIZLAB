package com.example.ilmizlab.screen.drawer_fragments.prices

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ilmizlab.R
import com.example.ilmizlab.databinding.FragmentPricesBinding
import com.example.ilmizlab.models.RatingModel
import com.example.ilmizlab.screen.MainViewModel
import com.example.ilmizlab.view.RatingAdapter

class PricesFragment : Fragment() {
    lateinit var binding: FragmentPricesBinding

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPricesBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

        binding.recyclerPrices.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)


        viewModel.ratingData.observe(requireActivity(), Observer {
            binding.recyclerPrices.adapter = RatingAdapter(it)
        })
        loadData()
    }
    fun loadData(){
        viewModel.getRating()
    }
    companion object {
        @JvmStatic
        fun newInstance() = PricesFragment()
    }
}