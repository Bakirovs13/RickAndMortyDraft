package com.example.rickandmortydraft.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortydraft.data.repository.RepositoryImpl
import com.example.rickandmortydraft.domain.CharacterRepository
import com.example.rickandmortydraft.domain.entities.Character
import com.example.rickandmortydraft.domain.usecases.GetCharacterByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class DetailViewModel:ViewModel() {

    private val repositoryImpl = RepositoryImpl()
     val characterByIdLD:MutableLiveData<Response<Character.Result>> = MutableLiveData()
    private val getCharacterByIdUseCase = GetCharacterByIdUseCase(repositoryImpl)


    fun getCharacterById(characterId:Int){
        viewModelScope.launch() {
            characterByIdLD.value = getCharacterByIdUseCase.getCharacterById(characterId)
        }
    }

}