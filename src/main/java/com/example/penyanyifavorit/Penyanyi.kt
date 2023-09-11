package com.example.penyanyifavorit

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Penyanyi(
    val name :String,
    val description :String,
    val photo : Int
) :Parcelable
