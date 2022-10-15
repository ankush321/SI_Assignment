package com.example.si_assignment.data.api

import com.example.si_assignment.data.model.ODIMatch
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("nzin01312019187360.json")
    suspend fun getMatchData(): Response<ODIMatch>}