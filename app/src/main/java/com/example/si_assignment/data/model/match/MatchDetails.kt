package com.example.si_assignment.data.model.match

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MatchDetails(
    @SerializedName("Equation")
    val equation: String,
    @SerializedName("Match")
    val match: Match,
    @SerializedName("Officials")
    val officials: Officials,
    @SerializedName("Player_Match")
    val playerMatch: String,
    @SerializedName("Result")
    val result: String,
    @SerializedName("Series")
    val series: Series,
    @SerializedName("Status")
    val status: String,
    @SerializedName("Status_Id")
    val statusId: String,
    @SerializedName("Team_Away")
    val teamAway: String,
    @SerializedName("Team_Home")
    val teamHome: String,
    @SerializedName("Tosswonby")
    val tossWonBy: String,
    @SerializedName("Venue")
    val venue: Venue,
    @SerializedName("Weather")
    val weather: String,
    @SerializedName("Winmargin")
    val winMargin: String,
    @SerializedName("Winningteam")
    val winningTeam: String
) : Parcelable