package com.example.si_assignment.data.model.match

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Officials(
    val Referee: String,
    val Umpires: String
) : Parcelable