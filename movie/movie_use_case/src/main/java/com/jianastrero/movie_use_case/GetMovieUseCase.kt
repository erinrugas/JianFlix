package com.jianastrero.movie_use_case

import com.jianastrero.core.domain.Resource
import com.jianastrero.movie_domain.MovieRepository
import com.jianastrero.movie_domain.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception

class GetMovieUseCase : KoinComponent{

    private val repository by inject<MovieRepository>()

    operator fun invoke(id: Int): Flow<Resource<Movie>> = flow {
        try {
            emit(Resource.Loading())

            val movie = repository.getById(id)

            emit(Resource.Success(movie))

        } catch (e: HttpException) {
            emit(Resource.Error.UnexpectedError())
        } catch (e: IOException) {
            emit(Resource.Error.NoInternetConnectionError())
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error occurred"))
        }
    }
}