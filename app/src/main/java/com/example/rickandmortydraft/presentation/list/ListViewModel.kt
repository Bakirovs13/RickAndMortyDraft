package com.example.rickandmortydraft.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortydraft.data.repository.RepositoryImpl
import com.example.rickandmortydraft.domain.entities.Character
import com.example.rickandmortydraft.domain.usecases.GetCharactersUseCase
import kotlinx.coroutines.launch
import retrofit2.Response

class ListViewModel:ViewModel() {

    private val repositoryImpl = RepositoryImpl()
    val listLD : MutableLiveData<Response<Character>> = MutableLiveData()
    private val getCharactersUseCase = GetCharactersUseCase(repositoryImpl)

    fun getall(){
        viewModelScope.launch {
            listLD.value = getCharactersUseCase.getCharacterList()
        }
    }

}