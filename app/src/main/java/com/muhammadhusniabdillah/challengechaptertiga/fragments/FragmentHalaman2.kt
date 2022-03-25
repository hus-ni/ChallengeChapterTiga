package com.muhammadhusniabdillah.challengechaptertiga.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.muhammadhusniabdillah.challengechaptertiga.R
import com.muhammadhusniabdillah.challengechaptertiga.databinding.FragmentHalaman2Binding

class FragmentHalaman2 : Fragment(R.layout.fragment_halaman2) {

    private var _binding: FragmentHalaman2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHalaman2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = getString(R.string.string_fragment_page_title, "Two")
        binding.tvTitleFragmentTwo.text = title
        val button = getString(R.string.string_goto_next_page, "3")
        binding.btnMovetofrag3FragmentTwo.text = button

        binding.btnMovetofrag3FragmentTwo.setOnClickListener {
            // cek apakah input nama kosong
            if (TextUtils.isEmpty(binding.etNamaFragmentTwo.editText?.text.toString())) {
                Snackbar.make(
                    binding.coorLayout,
                    getString(R.string.error_et_halaman2),
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                val sendDataToFragmentHalaman3 =
                    FragmentHalaman2Directions.actionFragmentHalaman2ToFragmentHalaman3()
                sendDataToFragmentHalaman3.nama =
                    binding.etNamaFragmentTwo.editText?.text.toString()
                findNavController()
                    .navigate(sendDataToFragmentHalaman3)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}