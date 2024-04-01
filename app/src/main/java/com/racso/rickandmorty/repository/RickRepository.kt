package com.racso.rickandmorty.repository

import android.util.Log
import com.racso.basiccodelabcompose.data.models.Result
import com.racso.basiccodelabcompose.data.network.RickApiService
import javax.inject.Inject

class RickRepository @Inject constructor(private val api: RickApiService){

    suspend fun getCharactersListFromRemote(): List<Result> =  api.getList().results

}