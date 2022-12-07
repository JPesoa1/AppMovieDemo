package com.example.appmoviedemo.repository

import com.example.appmoviedemo.data.model.MovieList

interface MovieRespository {
    suspend fun  getUpcomingMovies(): MovieList

    suspend fun getTopRatedMovies(): MovieList

    suspend fun getPopularMovies(): MovieList
}