package com.geunoo.android_lab.data.user

import com.geunoo.android_lab.data.user.dto.request.LoginRequest
import com.geunoo.android_lab.data.user.dto.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("/users/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse
}