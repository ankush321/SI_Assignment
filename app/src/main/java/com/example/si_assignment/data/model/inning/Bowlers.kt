package com.example.si_assignment.data.model.inning

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Bowlers(
    @SerializedName("Bowler")
    val bowler: String,
    @SerializedName("Dots")
    val dots: String,
    @SerializedName("Economyrate")
    val economyRate: String,
    @SerializedName("Maidens")
    val maidens: String,
    @SerializedName("Noballs")
    val noBalls: String,
    @SerializedName("Overs")
    val overs: String,
    @SerializedName("Runs")
    val runs: String,
    @SerializedName("Wickets")
    val wickets: String,
    @SerializedName("Wides")
    val wides: String,
    @SerializedName("Isbowlingtandem")
    val isBowlingtandem: Boolean?,
    @SerializedName("Isbowlingnow")
    val isBowlingNow: Boolean?,
    @SerializedName("ThisOver")
    val thisOver: List<Ball>?
) : Parcelable