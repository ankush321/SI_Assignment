package com.example.si_assignment.data.api

import com.example.si_assignment.data.model.ODIMatch
import retrofit2.Response

interface ApiHelper {
    suspend fun getMatchData(): Response<ODIMatch>
}