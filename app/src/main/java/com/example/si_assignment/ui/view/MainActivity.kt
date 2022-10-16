package com.example.si_assignment.ui.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.si_assignment.data.model.ODIMatch
import com.example.si_assignment.data.model.inning.InningDetaill
import com.example.si_assignment.data.model.match.Match
import com.example.si_assignment.data.model.team.Team
import com.example.si_assignment.databinding.ActivityMainBinding
import com.example.si_assignment.ui.viewmodel.MatchViewModel
import com.example.si_assignment.util.AppConstant
import com.example.si_assignment.util.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val matchViewModel: MatchViewModel by viewModel()
    private lateinit var odiMatch: ODIMatch
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setClickEvent()
        setUpObserver()
    }

    private fun setClickEvent() {
        binding.homeTeam.setOnClickListener {
            val team: Team = odiMatch.teams[odiMatch.matchDetail.teamHome.toInt()]!!
            val intent = Intent(this, PlayerDetail::class.java)
            intent.putExtra(AppConstant.SELECTED_TEAM, team)
            intent.putExtra(AppConstant.ODI_MATCH_DATA, odiMatch)
            startActivity(intent)
        }

        binding.teamAway.setOnClickListener {
            val team: Team = odiMatch.teams[odiMatch.matchDetail.teamAway.toInt()]!!
            val intent = Intent(this, PlayerDetail::class.java)
            intent.putExtra(AppConstant.SELECTED_TEAM, team)
            intent.putExtra(AppConstant.ODI_MATCH_DATA, odiMatch)
            startActivity(intent)
        }
    }

    private fun setUpObserver() {
        matchViewModel.matchDetail.observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    Log.d("Status ", it.data.toString())
                    binding.progressBar.visibility = View.INVISIBLE
                    binding.card.visibility = View.VISIBLE
                    odiMatch = it.data as ODIMatch
                    setData()
                }
                Status.LOADING -> {
                    Log.d("Status ", "Data Loading")
                    binding.card.visibility = View.INVISIBLE
                    binding.progressBar.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    Log.d("Status ", it.data.toString())
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setData() {
        val matchDetails = odiMatch.matchDetail
        val match: Match = matchDetails.match
        val homeTeam: Team = odiMatch.teams[matchDetails.teamHome.toInt()]!!
        val secondTeam: Team = odiMatch.teams[matchDetails.teamAway.toInt()]!!
        lateinit var homeTeamInning: InningDetaill
        lateinit var secondTeamInning: InningDetaill
        for (inning in odiMatch.innings) {
            if (matchDetails.teamHome == inning.battingTeam) {
                homeTeamInning = inning
            } else secondTeamInning = inning
        }

        binding.matchDate.text = match.date
        binding.venue.text = odiMatch.matchDetail.venue.name
        binding.homeTeamName.text = homeTeam.nameShort
        binding.homeTeam.text =
            "${homeTeamInning.total}-${homeTeamInning.wickets}\n(${homeTeamInning.overs})"
        binding.teamAwayName.text = secondTeam.nameShort
        binding.teamAway.text =
            "${secondTeamInning.total}-${secondTeamInning.wickets}\n(${secondTeamInning.overs})"
    }
}
