package com.ahmet.movieapp.presentation.movie_detail

import com.ahmet.movieapp.domain.model.MovieDetail

class MovieDetailState(
    val isLoading : Boolean = false,
    val movie : MovieDetail ?= null,
    val error : String = ""
) {

}