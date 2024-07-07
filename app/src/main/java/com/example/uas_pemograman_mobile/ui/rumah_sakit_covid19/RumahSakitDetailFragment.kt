package com.example.uas_pemograman_mobile.ui.rumah_sakit_covid19

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.uas_pemograman_mobile.databinding.FragmentRsDetailBinding
import com.example.uas_pemograman_mobile.ui.MyViewModel


class RumahSakitDetailFragment: Fragment() {
    private val viewModelrs: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRsDetailBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModelrs

        return binding.root
    }

}