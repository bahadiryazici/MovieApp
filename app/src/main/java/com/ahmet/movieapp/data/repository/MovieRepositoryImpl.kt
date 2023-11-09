package com.ahmet.movieapp.data.repository

import com.ahmet.movieapp.data.remote.MovieAPI
import com.ahmet.movieapp.data.remote.dto.MovieDetailDTO
import com.ahmet.movieapp.data.remote.dto.MoviesDTO
import com.ahmet.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api : MovieAPI) : MovieRepository {
    override suspend fun getMovies(search: String): MoviesDTO {
        return api.getMovies(search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDTO {
        return api.getMovieDetail(imdbId)
    }
}