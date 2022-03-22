package com.muhammadhusniabdillah.challengechaptertiga.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.muhammadhusniabdillah.challengechaptertiga.R
import com.muhammadhusniabdillah.challengechaptertiga.databinding.FragmentHalaman3Binding

class FragmentHalaman3 : Fragment(R.layout.fragment_halaman3) {

    private var _binding: FragmentHalaman3Binding? = null
    private val binding get() = _binding!!
    private val args: FragmentHalaman3Args by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHalaman3Binding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = getString(R.string.string_fragment_page_title)
        binding.tvTitleFragmentThree.text = "$title Three"
        val button = getString(R.string.string_goto_next_page)
        binding.btnMovetofrag4FragmentThree.text = "$button 4"

        val name = args.nama
        binding.tvOutputnamaFragmentThree.text = name

        binding.btnMovetofrag4FragmentThree.setOnClickListener{
            val toFragmentHalaman4 = FragmentHalaman3Directions.actionFragmentHalaman3ToFragmentHalaman4()
            findNavController()
                .navigate(toFragmentHalaman4)
        }
    }
}