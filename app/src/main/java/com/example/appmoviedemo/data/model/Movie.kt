package com.example.appmoviedemo.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Movie(
    val id: Int,
    val adult: Boolean,
    val backdrop_path: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int,
    val movie_type: String
)

data class MovieList(val results: List<Movie> = listOf())

//Room

@Entity
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "adult")
    val adult: Boolean,
    @ColumnInfo(name = "backdrop_path")
    val backdrop_path: String,
    @ColumnInfo(name = "original_language")
    val original_language: String,
    @ColumnInfo(name = "original_title")
    val original_title: String,
    @ColumnInfo(name = "overview")
    val overview: String,
    @ColumnInfo(name = "popularity")
    val popularity: Double,
    @ColumnInfo(name = "poster_path")
    val poster_path: String,
    @ColumnInfo(name = "release_date")
    val release_date: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "video")
    val video: Boolean,
    @ColumnInfo(name = "video_average")
    val vote_average: Double,
    @ColumnInfo(name = "vote_count")
    val vote_count: Int,
    @ColumnInfo(name = "movie_type")
    val movie_type: String
)

fun List<MovieEntity>.toMovieList(): MovieList {  //Mapeamos de ListMovieEntity a ListMovie ,es decir tiene los mismos campos o atributos pero no son el mismo objeto
    var resultsList = mutableListOf<Movie>()
    this.forEach {
        resultsList.add(it.toMovie())
    }
    return MovieList(resultsList)
}

fun MovieEntity.toMovie(): Movie = Movie(   //estamos creando una movie en base a movieentity ->Estamos transformando de movieentity a movie
    this.id,
    this.adult,
    this.backdrop_path,
    this.original_language,
    this.original_title,
    this.overview,
    this.popularity,
    this.poster_path,
    this.release_date,
    this.title,
    this.video,
    this.vote_average,
    this.vote_count,
    this.movie_type,
)

fun Movie.toMovieEntity(movie_type: String): MovieEntity= MovieEntity(   // ->Estamos transformando de   movie a movieentity
    this.id,
    this.adult,
    this.backdrop_path,
    this.original_language,
    this.original_title,
    this.overview,
    this.popularity,
    this.poster_path,
    this.release_date,
    this.title,
    this.video,
    this.vote_average,
    this.vote_count,
    movie_type= movie_type
)
