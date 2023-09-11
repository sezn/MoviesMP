package com.szn.domain.usecases

import com.szn.domain.model.Movie
import com.szn.domain.repo.MoviesRepository

class MovieUseCase(private val movieRepository: MoviesRepository) {

    suspend fun getMovieById(id: String): Movie? {
        return movieRepository.getMovieById(id)
    }

    suspend fun getMovies(id: String): List<Movie> {
        return movieRepository.getList(id)
    }
}