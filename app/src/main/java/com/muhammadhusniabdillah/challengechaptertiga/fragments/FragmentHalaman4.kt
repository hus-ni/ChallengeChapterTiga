package com.muhammadhusniabdillah.challengechaptertiga.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.muhammadhusniabdillah.challengechaptertiga.R
import com.muhammadhusniabdillah.challengechaptertiga.databinding.FragmentHalaman4Binding

class FragmentHalaman4 : Fragment(R.layout.fragment_halaman4) {

    private var _binding: FragmentHalaman4Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHalaman4Binding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = getString(R.string.string_fragment_page_title)
        binding.tvTitleFragmentFour.text = "$title Four"
        val button = getString(R.string.string_goto_next_page)
        binding.btnMovetofrag3FragmentFour.text = "$button 3"

        binding.btnMovetofrag3FragmentFour.setOnClickListener{
            val sendDataToFragment3 = FragmentHalaman4Directions.actionFragmentHalaman4ToFragmentHalaman3()
            findNavController()
                .navigate(sendDataToFragment3)
        }
    }
}