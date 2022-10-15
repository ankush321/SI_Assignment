package com.example.si_assignment.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.si_assignment.R
import com.example.si_assignment.data.model.team.player.PlayerDetail

class PlayerAdapter(private val context: Context, private var playerList: List<PlayerDetail>): RecyclerView.Adapter<PlayerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.player_view, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val player = playerList[position]
        var name = ""
        if (player.iscaptain != null && player.iscaptain) {
            name ="$name (C)"
            holder.itemView.setBackgroundColor(R.color.red)
        }
        if (player.iskeeper != null && player.iskeeper) {
            name ="$name (WK)"
        }
        holder.playerName.text = player.name_Full.plus(name)
        holder.runs.text = player.batting.runs
        holder.strikeRate.text = player.batting.strikeRate
        holder.battingAvg.text = player.batting.average
        holder.economyRate.text = player.bowling.economyrate
        holder.wickets.text = player.bowling.wickets
        holder.itemView.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setTitle(player.name_Full)
            builder.setMessage("Bowling Style : ${player.bowling.style}\n Batting Style : ${player.batting.style}")
            builder.show()
        }
    }

    fun updateList(list: List<PlayerDetail>){
        playerList = list
    }
    override fun getItemCount(): Int = playerList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val playerName: TextView = view.findViewById(R.id.player_name)
        val runs: TextView = view.findViewById(R.id.runs)
        val strikeRate: TextView = view.findViewById(R.id.strike_rate)
        val battingAvg: TextView = view.findViewById(R.id.batting_avg)
        val economyRate: TextView = view.findViewById(R.id.economy_rate)
        val wickets: TextView = view.findViewById(R.id.wickets)
    }
}