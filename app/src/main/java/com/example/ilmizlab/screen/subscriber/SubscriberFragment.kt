package com.example.ilmizlab.screen.subscriber

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ilmizlab.R


class SubscriberFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_subscriber, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() = SubscriberFragment()
    }
}