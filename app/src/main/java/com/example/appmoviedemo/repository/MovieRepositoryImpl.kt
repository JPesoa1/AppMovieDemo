package com.example.appmoviedemo.repository

import com.example.appmoviedemo.data.local.LocalMovieDataSource
import com.example.appmoviedemo.data.model.MovieList
import com.example.appmoviedemo.data.model.toMovieEntity
import com.example.appmoviedemo.data.remote.RemoteMovieDataSource

class MovieRepositoryImpl(
    private val dataSource: RemoteMovieDataSource,
    private val dataSourceLocal: LocalMovieDataSource
) : MovieRespository {
    override suspend fun getUpcomingMovies(): MovieList{
        dataSource.getUpcomingMovies().results.forEach {
            dataSourceLocal.saveMovie(it.toMovieEntity("upcoming"))
        }
        return dataSourceLocal.getUpcomingMovies()
    }

    override suspend fun getTopRatedMovies(): MovieList {
        dataSource.getTopRatedMovies().results.forEach {
            dataSourceLocal.saveMovie(it.toMovieEntity("toprated"))
        }
        return dataSourceLocal.getTopRatedMovies()
    }

    override suspend fun getPopularMovies(): MovieList {
        dataSource.getPopularMovies().results.forEach {
            dataSourceLocal.saveMovie(it.toMovieEntity("popular"))
        }
        return dataSourceLocal.getPopularMovies()
    }

    //Sin room

    //override suspend fun gePopularMovies():MovieList=dataSource.getPopularMovies()
    //override suspend fun getUpcomingMovies:MovieList=dataSource.getUpcomingMovies()
    //override suspend fun getTopRatedMovies():MovieList=dataSource.getTopRatedMovies()

}