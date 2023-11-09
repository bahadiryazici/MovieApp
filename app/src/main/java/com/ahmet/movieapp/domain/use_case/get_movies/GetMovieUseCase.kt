package com.ahmet.movieapp.domain.use_case.get_movies


import com.ahmet.movieapp.data.remote.dto.toMovieList
import com.ahmet.movieapp.domain.model.Movie
import com.ahmet.movieapp.domain.repository.MovieRepository
import com.ahmet.movieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovies(search : String) : Flow<Resource<List<Movie>>>{
        return flow {
            try {
                emit(Resource.Loading())
                val movieList = repository.getMovies(search)
                if(movieList.Response == "True"){
                    emit(Resource.Success(movieList.toMovieList()))
                }else{
                    emit(Resource.Error(message = "Movie not found!"))
                }
            }catch (e : IOError){
                emit(Resource.Error("No internet connection"))
            }catch (e: retrofit2.HttpException){
                emit(Resource.Error(e.localizedMessage ?: "Error"))
            }
        }
    }

}