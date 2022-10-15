package com.example.si_assignment.data.api

import com.example.si_assignment.data.model.ODIMatch
import retrofit2.Response

class ApiServiceImpl(private val apiService: ApiService): ApiHelper {
    override suspend fun getMatchData(): Response<ODIMatch> {
        return apiService.getMatchData()
    }
}