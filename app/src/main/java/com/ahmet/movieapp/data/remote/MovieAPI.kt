package com.ahmet.movieapp.data.remote

import com.ahmet.movieapp.data.remote.dto.MovieDetailDTO
import com.ahmet.movieapp.data.remote.dto.MoviesDTO
import com.ahmet.movieapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    //https://www.omdbapi.com/?apikey=766f730b&i=tt1285016
    //https://www.omdbapi.com/?apikey=766f730b&s=batman

    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString : String,
        @Query("apikey") apiKey : String = API_KEY
    ) : MoviesDTO

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId : String,
        @Query("apikey") apiKey : String = API_KEY
    ) : MovieDetailDTO
}