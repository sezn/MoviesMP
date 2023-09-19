package com.szn.domain.usecases

import com.szn.domain.model.Movie

interface GetMovieUseCase {
    suspend operator fun invoke(id: String): Movie
}