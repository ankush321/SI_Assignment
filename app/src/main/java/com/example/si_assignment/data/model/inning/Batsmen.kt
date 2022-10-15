package com.example.si_assignment.data.model.inning

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Batsmen(
    val Balls: String,
    val Batsman: String,
    val Runs: String
) : Parcelable