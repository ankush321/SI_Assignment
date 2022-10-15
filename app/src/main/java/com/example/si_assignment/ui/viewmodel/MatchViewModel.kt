package com.example.si_assignment.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.si_assignment.data.model.ODIMatch
import com.example.si_assignment.data.repository.MatchRepository
import com.example.si_assignment.util.NetworkHelper
import com.example.si_assignment.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.ResponseBody

class MatchViewModel(
    private val matchRepository: MatchRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _matchDetail = MutableLiveData<Resource<ODIMatch>>()
    val matchDetail: LiveData<Resource<ODIMatch>>
        get() = _matchDetail

    init {
        fetchMatchDetail()
    }

    private fun fetchMatchDetail() {
        viewModelScope.launch(Dispatchers.IO) {
            _matchDetail.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                matchRepository.getMatchDetail().let { it
                    if (it.isSuccessful) {
                        val body = it.body()
                        _matchDetail.postValue(Resource.success(body))
                    }else _matchDetail.postValue(Resource.error(it.errorBody().toString(), null))
                }
            }else _matchDetail.postValue(Resource.error("No internet connection", null))
        }
    }
}