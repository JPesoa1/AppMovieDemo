package com.example.appmoviedemo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.appmoviedemo.core.Resource
import com.example.appmoviedemo.repository.MovieRespository
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.coroutineContext


class MovieViewModel(private val repo : MovieRespository): ViewModel(){
    fun fetchMainScreenMovies () = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(Resource.Success(Triple(repo.getUpcomingMovies(),repo.getPopularMovies(),repo.getTopRatedMovies())))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }




}

class MovieViewModelFactory(private val repo : MovieRespository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MovieRespository::class.java).newInstance(repo)
    }
}