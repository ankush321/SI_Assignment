package com.example.si_assignment.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.si_assignment.ui.view.PlayerDetail

class PlayerDetailViewModel: ViewModel() {

    private val _playerList = MutableLiveData<List<PlayerDetail>>()
    val playerList: LiveData<List<PlayerDetail>>
        get() = _playerList

    fun setDate(list: List<PlayerDetail>){
        _playerList.postValue(list)
    }
}