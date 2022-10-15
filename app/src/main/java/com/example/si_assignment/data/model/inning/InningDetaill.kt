package com.example.si_assignment.data.model.inning

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class InningDetaill(
    @SerializedName("AllottedOvers")
    val allottedOvers: String,
    @SerializedName("Batsmen")
    val batsmenPerformance: List<Batsmens>,
    @SerializedName("Battingteam")
    val battingTeam: String,
    @SerializedName("Bowlers")
    val bowlers: List<Bowlers>,
    @SerializedName("Byes")
    val byes: String,
    @SerializedName("FallofWickets")
    val fallOfWickets: List<FallofWicket>,
    @SerializedName("Legbyes")
    val legByes: String,
    @SerializedName("Noballs")
    val noBalls: String,
    @SerializedName("Number")
    val number: String,
    @SerializedName("Overs")
    val overs: String,
    @SerializedName("Partnership_Current")
    val partnershipCurrent: PartnershipCurrent,
    @SerializedName("Penalty")
    val penalty: String,
    @SerializedName("PowerPlay")
    val powerPlay: PowerPlay,
    @SerializedName("Runrate")
    val runRate: String,
    @SerializedName("Total")
    val total: String,
    @SerializedName("Wickets")
    val wickets: String,
    @SerializedName("Wides")
    val wides: String
) : Parcelable