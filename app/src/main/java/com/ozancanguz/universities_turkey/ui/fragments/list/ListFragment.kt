package com.ozancanguz.universities_turkey.ui.fragments.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ozancanguz.universities_turkey.R
import com.ozancanguz.universities_turkey.databinding.FragmentListBinding
import com.ozancanguz.universities_turkey.viewmodels.ListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null

    private val binding get() = _binding!!
    private val listViewModel:ListViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root

        observeLiveData()

        binding.tv.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_detailsFragment)
        }

        return view
    }

    private fun observeLiveData() {
        listViewModel.requestApiData()
        listViewModel.universityList.observe(viewLifecycleOwner, Observer {
            Log.d("listfragment","succes" +it)
        })

    }


}