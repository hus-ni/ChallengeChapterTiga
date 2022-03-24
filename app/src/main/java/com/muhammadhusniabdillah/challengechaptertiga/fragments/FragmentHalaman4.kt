package com.muhammadhusniabdillah.challengechaptertiga.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.muhammadhusniabdillah.challengechaptertiga.R
import com.muhammadhusniabdillah.challengechaptertiga.SukuBunga
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


        binding.btnMovetofrag3FragmentFour.setOnClickListener {
            // check apakah ada input field yang kosong
            if (TextUtils.isEmpty(binding.etNamaBankFragmentFour.editText?.text.toString())
                || TextUtils.isEmpty(binding.etSukuBungaFragmentFour.editText?.text.toString())
                || TextUtils.isEmpty(binding.etTotalTabunganFragmentFour.editText?.text.toString())
                || TextUtils.isEmpty(binding.etLamaTersimpanFragmentFour.editText?.text.toString())
            ) {
                Snackbar.make(view,
                    "Semua Field harus diisi! Tidak boleh kosong",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                val namaBank = binding.etNamaBankFragmentFour.editText?.text.toString()
                val sukuBunga =
                    binding.etSukuBungaFragmentFour.editText?.text.toString().toDouble()
                val totalTabungan =
                    binding.etTotalTabunganFragmentFour.editText?.text.toString().toInt()
                val lamaTersimpan =
                    binding.etLamaTersimpanFragmentFour.editText?.text.toString().toInt()

                //here to put data parcelable
                val data = SukuBunga(
                    namaBank,
                    sukuBunga,
                    totalTabungan,
                    lamaTersimpan
                )
                // rumus hitung
                val hitungBunga = ((((sukuBunga/100) / 12) * totalTabungan) * lamaTersimpan)

                // Directions dari action fragment 4 ke fragment 3
                val sendDataToFragment3 =
                    FragmentHalaman4Directions.actionFragmentHalaman4ToFragmentHalaman3()
                sendDataToFragment3.nama = hitungBunga.toInt().toString()
                sendDataToFragment3.dataHalaman4 = data

                // menggunakan argument 'nama' yang tidak dipakai pada saat sampai di fragment 4
                // untuk mengirim data hasil perhitungan menggunakan safeargs


                findNavController()
                    .navigate(sendDataToFragment3)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}