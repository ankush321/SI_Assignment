package com.example.si_assignment.data.model.inning

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PartnershipCurrent(
    @SerializedName("Balls")
    val balls: String,
    @SerializedName("Batsmen")
    val batsmenContribution: List<Batsmen>,
    @SerializedName("Runs")
    val runs: String
) : Parcelable