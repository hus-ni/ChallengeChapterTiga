package com.muhammadhusniabdillah.challengechaptertiga.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.muhammadhusniabdillah.challengechaptertiga.R
import com.muhammadhusniabdillah.challengechaptertiga.databinding.FragmentHalaman1Binding

class FragmentHalaman1 : Fragment(R.layout.fragment_halaman1) {

    private var _binding: FragmentHalaman1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHalaman1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = getString(R.string.string_fragment_page_title, "One")
        binding.tvTitleFragmentOne.text = title
        val button = getString(R.string.string_goto_next_page, "2")
        binding.btnMovetofrag2FragmentOne.text = button

        //pindah ke halaman 2
        binding.btnMovetofrag2FragmentOne.setOnClickListener{
            findNavController()
                .navigate(R.id.action_fragmentHalaman1_to_fragmentHalaman2)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}