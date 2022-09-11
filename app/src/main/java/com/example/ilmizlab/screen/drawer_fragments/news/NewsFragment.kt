package com.example.ilmizlab.screen.drawer_fragments.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ilmizlab.databinding.FragmentNewsBinding
import com.example.ilmizlab.screen.MainViewModel
import com.example.ilmizlab.view.NewsAdapter

class NewsFragment : Fragment() {

    lateinit var binding: FragmentNewsBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerNews.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)

        viewModel.newsData.observe(requireActivity(), Observer {
            binding.recyclerNews.adapter = NewsAdapter(it)
        })
        loadData()
    }

    fun loadData() {
        viewModel.getNews()
    }

    companion object {

        @JvmStatic
        fun newInstance() = NewsFragment()
    }
}