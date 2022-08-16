package com.example.rickandmortydraft.data.repository

import com.example.rickandmortydraft.data.remote.RetrofitInstance
import com.example.rickandmortydraft.domain.CharacterRepository
import com.example.rickandmortydraft.domain.entities.Character
import retrofit2.Response

class RepositoryImpl : CharacterRepository {


    override suspend fun getCharacters(): Response<Character> {
       return  RetrofitInstance.api.getCharacters()
    }

    override suspend fun getCharacterById(characterId: Int): Response<Character.Result> {
      return RetrofitInstance.api.getCharacterById(characterId)
    }

}