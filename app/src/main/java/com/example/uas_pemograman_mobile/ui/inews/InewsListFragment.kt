package com.example.uas_pemograman_mobile.ui.inews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.uas_pemograman_mobile.R
import com.example.uas_pemograman_mobile.databinding.FragmentInewsListBinding
import com.example.uas_pemograman_mobile.ui.MyViewModel

class InewsListFragment: Fragment() {
    private val viewModelInews: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentInewsListBinding.inflate(inflater)
        viewModelInews.getInewsData()
        binding.lifecycleOwner = this
        binding.viewModel = viewModelInews
        binding.recyclerView.adapter = InewsListAdapter(InewsListener { inews ->
            viewModelInews.onInewsClicked(inews)
            findNavController()
                .navigate(R.id.action_nav_inewsListFragment_to_inewsDetailFragment)
        })
        (activity as AppCompatActivity).supportActionBar?.title = "INews"

        return binding.root
    }
}