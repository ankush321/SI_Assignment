package com.example.si_assignment.data.model.inning

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ball(
    val B: String,
    val T: String
) : Parcelable