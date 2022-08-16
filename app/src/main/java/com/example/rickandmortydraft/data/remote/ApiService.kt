package com.example.rickandmortydraft.data.remote

import com.example.rickandmortydraft.domain.entities.Character
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("character")
   suspend fun getCharacters():Response<Character>


   @GET("character/{characterId}")
   suspend fun getCharacterById(
       @Path("characterId") characterId: Int
   ) : Response<Character.Result>

}