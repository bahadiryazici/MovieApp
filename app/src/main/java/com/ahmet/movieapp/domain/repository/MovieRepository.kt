package com.ahmet.movieapp.domain.repository

import com.ahmet.movieapp.data.remote.dto.MovieDetailDTO
import com.ahmet.movieapp.data.remote.dto.MoviesDTO

interface MovieRepository {

    suspend fun getMovies(search : String) : MoviesDTO
    suspend fun getMovieDetail(imdbId : String) : MovieDetailDTO
}