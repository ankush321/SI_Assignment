package com.example.si_assignment.data.repository

import com.example.si_assignment.data.api.ApiHelper
import com.example.si_assignment.data.model.ODIMatch
import retrofit2.Response

class MatchRepository(private val apiHelper: ApiHelper) {

    suspend fun getMatchDetail(): Response<ODIMatch> {
        return apiHelper.getMatchData()
    }
}