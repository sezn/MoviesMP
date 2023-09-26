package com.szn.domain.di

import com.szn.domain.repo.AuthRepositoryImpl
import com.szn.movies.network.authAPI
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val authModule = module {
    singleOf(::AuthRepositoryImpl)
    singleOf(::authAPI)
}