package com.example.rickandmortydraft.domain.usecases

import com.example.rickandmortydraft.domain.CharacterRepository
import com.example.rickandmortydraft.domain.entities.Character
import retrofit2.Response


class GetCharactersUseCase(private val repository: CharacterRepository) {

    suspend fun getCharacterList(): Response<Character> {
        return  repository.getCharacters()
    }
}