package com.example.si_assignment.data.model.team.player

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Batting(
    @SerializedName("Average")
    val average: String,
    @SerializedName("Runs")
    val runs: String,
    @SerializedName("Strikerate")
    val strikeRate: String,
    @SerializedName("Style")
    val style: String
) : Parcelable