package com.example.ilmizlab.screen.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.ilmizlab.databinding.FragmentHomeBinding
import com.example.ilmizlab.models.CategoryModel
import com.example.ilmizlab.models.OfferModel
import com.example.ilmizlab.models.TrainingCenterModel
import com.example.ilmizlab.screen.DetailActivity
import com.example.ilmizlab.screen.MainViewModel
import com.example.ilmizlab.screen.ScienceActivity
import com.example.ilmizlab.utils.Constants
import com.example.ilmizlab.view.*
import java.util.Collections.emptyList


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    lateinit var viewModel: MainViewModel

//    var offers: List<OfferModel> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.swipe.setOnRefreshListener {
            loadData()
        }
        viewModel.progress.observe(requireActivity(), Observer {
            binding.swipe.isRefreshing = it
        })

        viewModel.error.observe(requireActivity(), Observer {
            Toast.makeText(requireActivity(), it, Toast.LENGTH_LONG).show()
        })
        viewModel.offersData.observe(requireActivity(), Observer {
          binding.carouselView.setImageListener { position, imageView ->
                Glide.with(imageView).load("http://demo.ilm-izlab.uz/${it[position].image}")
                    .into(imageView)
            }
            binding.carouselView.pageCount = it.count()
        })
        viewModel.categoriesData.observe(requireActivity(), Observer {
            binding.recyclerCategories.adapter =
                CategoryAdapter(it, object : CategoryAdapterCallback {
                    override fun onClickItem(item: CategoryModel) {
                        val intent = Intent(requireActivity(), ScienceActivity::class.java)
                        intent.putExtra(Constants.EXTRA_DATA, item)
                        requireActivity().startActivity(intent)
                    }
                })
        })
        viewModel.centerTopData.observe(requireActivity(), Observer {
            binding.recyclerTopCenter.adapter =
                TopCenterAdapter(it, object : TopCenterAdapterCallback {
                    override fun onClickItem(item: TrainingCenterModel) {
                        val intent = Intent(requireActivity(), DetailActivity::class.java)
                        intent.putExtra(Constants.EXTRA_DATA, item)
                        requireActivity().startActivity(intent)

                    }
                })
        })
        viewModel.centerData.observe(requireActivity(), Observer {
            binding.recyclerNearbyCenters.adapter =
                CenterAdapter(it, object : CenterAdapterCallback {
                    override fun onClickItem(item: TrainingCenterModel) {
                        val intent = Intent(requireActivity(), DetailActivity::class.java)
                        intent.putExtra(Constants.EXTRA_DATA, item)
                        requireActivity().startActivity(intent)
                    }
                })
        })
        binding.recyclerCategories.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerTopCenter.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)


        binding.recyclerNearbyCenters.layoutManager = GridLayoutManager(requireActivity(), 2)

        loadData()

    }

    fun loadData() {
        viewModel.getOffers()
        viewModel.getCategories()
        viewModel.getTrainingTopCenter()
        viewModel.getTrainingCenter()

    }

    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment()
    }


}