package com.example.gamecollector.auth.data.remote

import com.example.gamecollector.auth.data.TokenHolder
import com.example.gamecollector.auth.data.User
import com.example.gamecollector.core.Api
import com.example.gamecollector.core.Result
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

import java.lang.Exception

object RemoteAuthDataSource {
    interface AuthService {
        @Headers("Content-Type: application/json")
        @POST("/api/auth/login")
        suspend fun login(@Body user: User): TokenHolder
    }
    private val authService: AuthService = Api.retrofit.create(AuthService::class.java)

    suspend fun login(user: User): Result<TokenHolder> {
        try {
            return Result.Success(authService.login(user))
        } catch(e: Exception) {
            return Result.Error(e)
        }
    }
}

