package com.example.gamecollector.auth.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamecollector.auth.data.AuthRepository
import com.example.gamecollector.auth.data.TokenHolder
import com.example.gamecollector.core.Result
import com.example.gamecollector.core.TAG
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {


    private val mutableLoginResult = MutableLiveData<Result<TokenHolder>>()
    val loginResult: LiveData<Result<TokenHolder>> = mutableLoginResult


    fun login(username: String, password: String) {
        viewModelScope.launch {
            Log.v(TAG, "login...")
            mutableLoginResult.value = AuthRepository.login(username, password)
        }
    }


}