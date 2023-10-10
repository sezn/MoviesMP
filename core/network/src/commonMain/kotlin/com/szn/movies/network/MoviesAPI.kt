package com.szn.network

import com.szn.movies.network.model.movies.Movie
import com.szn.movies.network.model.movies.Movies
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query
interface MoviesAPI {

    companion object {
        const val baseUrl = "http://api.themoviedb.org/"
        val API_KEY = "TODO"
    }
    @GET("3/movie/{movie_id}")
    suspend fun getMovie(@Path("movie_id")id: Int,
                         @Query("language") lang: String? = "fr",
                         @Query("api_key") key: String = API_KEY
    ): Movie


    @GET("4/discover/movie")
    suspend fun getMovies(@Query("sort_by") sort: String? = null,
                          @Query("language") lang: String? = "fr",
                          @Query("page") page: Int? = 1,
                          @Query("api_key") key: String = API_KEY
    ): Movies

}