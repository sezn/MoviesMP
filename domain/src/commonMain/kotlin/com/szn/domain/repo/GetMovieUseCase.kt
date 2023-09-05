package com.szn.domain.repo

import com.szn.domain.model.Movie

interface MovieRepository {
    suspend fun getMovieById(id: String): Movie?
    suspend fun getList(id: String): List<Movie>
}