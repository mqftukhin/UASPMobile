package com.example.uas_pemograman_mobile.ui.update_covid19

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.uas_pemograman_mobile.R
import com.example.uas_pemograman_mobile.databinding.FragmentUpdateListBinding
import com.example.uas_pemograman_mobile.ui.MyViewModel

class DataKematianListFragment: Fragment() {
    private val viewModelUpdate: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentUpdateListBinding.inflate(inflater)
        viewModelUpdate.getUpdateData2()
        binding.lifecycleOwner = this
        binding.viewModel = viewModelUpdate
        binding.recyclerView.adapter = DataKematianListAdapter(DataKematianListener { dataCovid ->
            viewModelUpdate.onUpdateDataClicked(dataCovid)
            findNavController()
                .navigate(R.id.action_nav_updateListFragment_to_updateDetailFragment)
        })
        (activity as AppCompatActivity).supportActionBar?.title = "Daftar Angka Kematian Covid19"

        return binding.root
    }
}