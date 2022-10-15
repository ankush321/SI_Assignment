package com.example.si_assignment.data.model.team

import android.os.Parcelable
import com.example.si_assignment.data.model.team.player.PlayerDetail
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(
    @SerializedName("Name_Full")
    val nameFull: String,
    @SerializedName("Name_Short")
    val nameShort: String,
    @SerializedName("Players")
    val players: HashMap<String, PlayerDetail>
): Parcelable
