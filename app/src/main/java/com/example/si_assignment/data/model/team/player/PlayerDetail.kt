package com.example.si_assignment.data.model.team.player

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlayerDetail(
    @SerializedName("Batting")
    val batting: Batting,
    @SerializedName("Bowling")
    val bowling: Bowling,
    @SerializedName("Iscaptain")
    val iscaptain: Boolean?,
    @SerializedName("Iskeeper")
    val iskeeper: Boolean?,
    @SerializedName("Name_Full")
    val name_Full: String,
    @SerializedName("Position")
    val position: Int
):Parcelable