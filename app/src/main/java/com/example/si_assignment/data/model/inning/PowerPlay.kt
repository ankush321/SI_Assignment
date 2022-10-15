package com.example.si_assignment.data.model.inning

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PowerPlay(
    val PP1: String,
    val PP2: String
) : Parcelable