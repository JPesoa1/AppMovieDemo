package com.example.appmoviedemo.data.local

import com.example.appmoviedemo.application.AppConstants
import com.example.appmoviedemo.data.model.MovieEntity
import com.example.appmoviedemo.data.model.MovieList
import com.example.appmoviedemo.data.model.toMovieList

class LocalMovieDataSource(private val movieDao: MovieDao) {
    suspend fun getUpcomingMovies(): MovieList {

        return movieDao.getAllMovies().filter { it.movie_type=="upcoming" }.toMovieList()
    }

    suspend fun getTopRatedMovies(): MovieList {
        return movieDao.getAllMovies().filter { it.movie_type=="toprated" }.toMovieList()
    }

    suspend fun getPopularMovies(): MovieList {
        return movieDao.getAllMovies().filter { it.movie_type=="popular" }.toMovieList()
    }

    suspend fun saveMovie(movie:MovieEntity){
        movieDao.saveMovie(movie)
    }

}