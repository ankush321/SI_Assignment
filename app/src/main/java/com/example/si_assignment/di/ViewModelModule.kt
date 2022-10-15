package com.example.si_assignment.di

import com.example.si_assignment.ui.viewmodel.MatchViewModel
import com.example.si_assignment.ui.viewmodel.PlayerDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MatchViewModel(matchRepository = get(), networkHelper = get())
    }
}