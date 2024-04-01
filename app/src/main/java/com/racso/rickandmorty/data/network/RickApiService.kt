package com.racso.basiccodelabcompose.data.network

import com.racso.basiccodelabcompose.data.models.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RickApiService {
    @GET("character/")
    suspend fun getList(@Query("page") page: Int = 1): ApiResponse
}