package com.ahmet.movieapp.domain.use_case.get_movie_detail

import com.ahmet.movieapp.data.remote.dto.toMovieDetail
import com.ahmet.movieapp.domain.model.MovieDetail
import com.ahmet.movieapp.domain.repository.MovieRepository
import com.ahmet.movieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository: MovieRepository){

    fun executeGetMovieDetail(imdbId : String) : Flow<Resource<MovieDetail>>{
        return flow {
            try {
                emit(Resource.Loading())
                val movieDetail = repository.getMovieDetail(imdbId)
                if (movieDetail.Response == "True"){
                    emit(Resource.Success(movieDetail.toMovieDetail()))
                }else{
                    emit(Resource.Error("Movie not found!"))
                }
            }catch (e: IOError){
                emit(Resource.Error("No internet connection"))
            }catch (e: HttpException){
                emit(Resource.Error(e.localizedMessage ?: "Error"))
            }
        }
    }
}