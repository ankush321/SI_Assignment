package com.example.si_assignment.data.model.inning

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Batsmens(
    @SerializedName("Balls")
    val balls: String,
    @SerializedName("Batsman")
    val batsman: String,
    @SerializedName("Bowler")
    val bowler: String,
    @SerializedName("Dismissal")
    val dismissal: String,
    @SerializedName("Isonstrike")
    val isOnStrike: Boolean?,
    @SerializedName("Dots")
    val dots: String,
    @SerializedName("Fielder")
    val fielder: String,
    @SerializedName("Fours")
    val fours: String,
    @SerializedName("Howout")
    val howout: String,
    @SerializedName("Runs")
    val runs: String,
    @SerializedName("Sixes")
    val sixes: String,
    @SerializedName("Strikerate")
    val strikeRate: String
) : Parcelable