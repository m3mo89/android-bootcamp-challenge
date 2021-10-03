package com.wizeline.bootcamp.challenge.ui.pokemondetail

import androidx.lifecycle.*
import com.wizeline.bootcamp.challenge.data.mock.PokemonDetails
import com.wizeline.bootcamp.challenge.data.repo.PokemonDetailsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val pokemonDetailsRepo: PokemonDetailsRepo
) : ViewModel() {

    // Implement a function that communicates with the PokemonDetailsRepo to get the needed info.
    private val _id = MutableLiveData<Long>()

    private val _pokemon = _id.switchMap { id ->
        liveData(Dispatchers.IO)
        {
            val response = pokemonDetailsRepo.getPokemonDetails(id)

            val pokemonDetail = response.body()
            emit(pokemonDetail!!)
        }
    }

    val pokemon : LiveData<PokemonDetails> = _pokemon

    fun init(id: Long){
        _id.value = id
    }
}
