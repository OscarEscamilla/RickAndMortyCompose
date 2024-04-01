package com.racso.rickandmorty.domain

import com.racso.basiccodelabcompose.data.models.Result
import com.racso.rickandmorty.repository.RickRepository
import javax.inject.Inject

class GetCharactersListUseCase @Inject constructor(private val repository: RickRepository) {

    suspend operator fun invoke(): List<Result> {
        // here we would implement source of true principle
        return repository.getCharactersListFromRemote()
    }
}