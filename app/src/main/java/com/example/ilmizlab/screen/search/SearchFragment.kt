package com.example.ilmizlab.screen.search
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ilmizlab.databinding.FragmentSearchBinding
import com.example.ilmizlab.models.TrainingCenterModel
import com.example.ilmizlab.screen.DetailActivity
import com.example.ilmizlab.screen.MainViewModel
import com.example.ilmizlab.utils.Constants
import com.example.ilmizlab.view.CenterSearchAdapter
import com.example.ilmizlab.view.CenterSearchCallback

class SearchFragment : Fragment() {
    lateinit var binding: FragmentSearchBinding

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
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.centerData.observe(requireActivity(), Observer {
            binding.recyclerSearchView.adapter =
                CenterSearchAdapter(it, object : CenterSearchCallback {
                    override fun onClickItem(item: TrainingCenterModel) {
                        val intent = Intent(requireActivity(), DetailActivity::class.java)
                        intent.putExtra(Constants.EXTRA_DATA, item)
                        requireActivity().startActivity(intent)
                    }
                })
        })

        binding.recyclerSearchView.layoutManager = GridLayoutManager(requireActivity(), 2)

        loadData()


    }
    fun loadData(){
        viewModel.getCenterSearch()
    }

    companion object {

        @JvmStatic
        fun newInstance() =  SearchFragment()
    }
}