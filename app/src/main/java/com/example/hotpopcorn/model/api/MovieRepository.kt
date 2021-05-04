package com.example.hotpopcorn.model.api

import com.example.hotpopcorn.model.*
import com.example.hotpopcorn.model.responses.MovieListResponse
import com.example.hotpopcorn.model.responses.PeopleFromMovieOrTVShowListResponse
import retrofit2.Call

// Functions connected with Movie objects - general and details:
class MovieRepository(private val apiRequest : ApiRequest) {
    fun searchForMovies(someText : String) : Call<MovieListResponse> = apiRequest.searchForMovies(someText)
    fun getPopularMovies() : Call<MovieListResponse> = apiRequest.getPopularMovies()
    fun getMovieDetails(movieID : Int) : Call<Movie> = apiRequest.getMovieDetails(movieID)
    fun getPeopleFromThisMovie(movieID: Int) : Call<PeopleFromMovieOrTVShowListResponse> = apiRequest.getPeopleFromThisMovie(movieID)
}