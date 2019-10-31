package com.example.w5d3_databinding

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.w5d3_databinding.databinding.FirstFragmentLayoutBinding
import com.example.w5d3_databinding.databinding.ThirdFragmentLayoutBinding

class Fragment3 : Fragment(){

    val myViewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity(),
            ViewModelProvider.AndroidViewModelFactory(requireActivity().application))
            .get(MainViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : ThirdFragmentLayoutBinding =
            DataBindingUtil.inflate(inflater, R.layout.third_fragment_layout, container, false)

        val view: View = binding.root
        binding.mainViewModel = myViewModel.viewProperties

        return view
    }
}