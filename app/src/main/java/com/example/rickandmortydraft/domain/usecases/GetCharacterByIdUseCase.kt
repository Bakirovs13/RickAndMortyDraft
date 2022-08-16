package com.example.rickandmortydraft.domain.usecases

import com.example.rickandmortydraft.domain.CharacterRepository
import com.example.rickandmortydraft.domain.entities.Character
import retrofit2.Response

class GetCharacterByIdUseCase(private val repository: CharacterRepository) {

    suspend fun getCharacterById(characterId:Int) : Response<Character.Result>{
        return repository.getCharacterById(characterId)
    }
}