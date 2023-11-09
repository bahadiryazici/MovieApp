package com.ahmet.movieapp.presentation.movies

sealed class MoviesEvent{
    data class Search(val searchString : String) : MoviesEvent()
}