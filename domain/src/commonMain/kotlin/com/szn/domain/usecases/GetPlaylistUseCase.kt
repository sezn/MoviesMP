package com.szn.domain.usecases

import com.szn.domain.model.Movie

interface GetPlaylistUseCase {
    suspend operator fun invoke(): List<Movie>
}