package com.jianastrero.movie_use_case.di

import com.jianastrero.movie_use_case.GetMovieUseCase
import com.jianastrero.movie_use_case.GetMoviesUseCase
import org.koin.dsl.module

val movieUseCaseModule = module {

    factory { GetMoviesUseCase() }
    factory { GetMovieUseCase() }

}