package com.example.si_assignment.di

import com.example.si_assignment.data.api.ApiService
import com.example.si_assignment.data.repository.MatchRepository
import org.koin.dsl.module

val repoModule = module {
    single { MatchRepository(apiHelper = get()) }
}