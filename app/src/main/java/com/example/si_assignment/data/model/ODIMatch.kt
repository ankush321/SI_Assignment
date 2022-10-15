package com.example.si_assignment.data.model

import android.os.Parcelable
import com.example.si_assignment.data.model.inning.InningDetaill
import com.example.si_assignment.data.model.match.MatchDetails
import com.example.si_assignment.data.model.team.Team
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ODIMatch(
    @SerializedName("Matchdetail")
    val matchDetail: MatchDetails,
    @SerializedName("Nuggets")
    val nuggets: List<String>,
    @SerializedName("Innings")
    val innings: List<InningDetaill>,
    @SerializedName("Teams")
    val teams: HashMap<Int, Team>,
    @SerializedName("Notes")
    val notes: HashMap<Int, List<String>>
) : Parcelable
