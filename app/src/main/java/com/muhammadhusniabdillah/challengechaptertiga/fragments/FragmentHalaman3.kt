package com.muhammadhusniabdillah.challengechaptertiga.fragments

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = getString(R.string.string_fragment_page_title, "Three")
        binding.tvTitleFragmentThree.text = title
        val button = getString(R.string.string_goto_next_page, "4")
        binding.btnMovetofrag4FragmentThree.text = button

        if (args.dataHalaman4 == null) {
            // nama dari halaman 2
            val name = args.nama
            binding.tvNumber3FragmentThree.visibility = View.VISIBLE
            binding.tvNumber3FragmentThree.text = name
        } else {
            // data parcelable dari halaman 4
            val dataFromHalaman4 = args.dataHalaman4
            binding.tvNumber0FragmentThree.visibility = View.VISIBLE
            binding.tvNumber0FragmentThree.text =
                getString(
                    R.string.string_nama_bank_4,
                    dataFromHalaman4?.nama_bank
                )
            binding.tvNumber1FragmentThree.visibility = View.VISIBLE
            binding.tvNumber1FragmentThree.text =
                getString(
                    R.string.string_tingkat_bunga_4,
                    dataFromHalaman4?.suku_bunga.toString()
                )
            binding.tvNumber2FragmentThree.visibility = View.VISIBLE
            binding.tvNumber2FragmentThree.text =
                getString(
                    R.string.string_total_tabungan_4,
                    dataFromHalaman4?.total_tabungan.toString()
                )
            binding.tvNumber3FragmentThree.visibility = View.VISIBLE
            binding.tvNumber3FragmentThree.text =
                getString(
                    R.string.string_hasil_bunga_4,
                    dataFromHalaman4?.lama_tersimpan.toString(),
                    args.nama // nama disini berisi hasil hitung dari halaman 4
                )
            // tombol pindah halaman 4 di sembunyikan
            binding.btnMovetofrag4FragmentThree.visibility = View.INVISIBLE
        }

        // pindah ke halaman 4
        binding.btnMovetofrag4FragmentThree.setOnClickListener {
            val toFragmentHalaman4 =
                FragmentHalaman3Directions.actionFragmentHalaman3ToFragmentHalaman4()
            findNavController()
                .navigate(toFragmentHalaman4)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}