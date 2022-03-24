package com.muhammadhusniabdillah.challengechaptertiga

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class SukuBunga(
    val nama_bank: String,
    val suku_bunga: Double,
    val total_tabungan: Int,
    val lama_tersimpan: Int
) : Parcelable