package com.example.cats.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cats.BaseFragment
import com.example.cats.databinding.FragmentFirstBinding
import com.example.cats.navigator.Navigator

class FirstFragment : BaseFragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            Navigator.get().navToSecondFragment()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}