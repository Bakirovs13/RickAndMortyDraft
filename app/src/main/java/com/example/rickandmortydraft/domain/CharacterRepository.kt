package com.example.rickandmortydraft.domain

import com.example.rickandmortydraft.domain.entities.Character
import retrofit2.Response

interface CharacterRepository {

    suspend fun getCharacters():Response<Character>

    suspend fun getCharacterById(characterId :Int):Response<Character.Result>
}