package com.example.ilmizlab.screen.drawer_fragments.course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ilmizlab.databinding.FragmentCoursesBinding
import com.example.ilmizlab.models.CoursesModel
import com.example.ilmizlab.screen.MainViewModel
import com.example.ilmizlab.view.CourseAdapter


class CoursesFragment : Fragment() {
    lateinit var binding: FragmentCoursesBinding
    lateinit var item: CoursesModel
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
        binding = FragmentCoursesBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.recyclerCourse.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        viewModel.coursesData.observe(requireActivity(), Observer {
            binding.recyclerCourse.adapter = CourseAdapter(it)

        })
        loadData()
    }
    fun loadData() {
        viewModel.getCourses()
    }

    companion object {
        @JvmStatic
        fun newInstance() = CoursesFragment()
    }

}