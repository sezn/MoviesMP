package com.szn.domain.usecases

import com.szn.domain.model.Movie
import com.szn.domain.repo.MovieRepository

class MovieUseCase(private val movieRepository: MovieRepository) {

    suspend fun getMovieById(id: String): Movie? {
        return movieRepository.getMovieById(id)
    }

    suspend fun getMovies(id: String): List<Movie> {
        return movieRepository.getList(id)
    }
}