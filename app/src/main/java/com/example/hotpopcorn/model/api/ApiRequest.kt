package com.example.hotpopcorn.model.api

import com.example.hotpopcorn.model.*
import com.example.hotpopcorn.model.responses.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// Interface responsible for communicating with TMDB RESTAPI:
interface ApiRequest {

    //                                  MOVIES SECTION
    @GET("3/search/movie?api_key=$apiKey")
    fun searchForMovies(@Query("query") someText : String,
                        @Query("language") language : String) : Call<MovieListResponse>

    @GET("3/movie/popular?api_key=$apiKey")
    fun getPopularMovies(@Query("language") language : String) : Call<MovieListResponse>

    @GET("3/movie/{movieID}?api_key=$apiKey")
    fun getMovieDetails(@Path("movieID") movieID : Int,
                        @Query("language") language : String) : Call<Movie>

    @GET("3/movie/{movieID}/credits?api_key=$apiKey")
    fun getPeopleFromThisMovie(@Path("movieID") movieID : Int,
                               @Query("language") language : String) : Call<PeopleFromMovieOrTVShowListResponse>



    //                                 TV SHOWS SECTION
    @GET("3/search/tv?api_key=$apiKey")
    fun searchForTVShows(@Query("query") someText : String,
                         @Query("language") language : String) : Call<TVShowListResponse>

    @GET("3/tv/popular?api_key=$apiKey")
    fun getPopularTVShows(@Query("language") language : String) : Call<TVShowListResponse>

    @GET("3/tv/{tvShowID}?api_key=$apiKey")
    fun getTVShowDetails(@Path("tvShowID") tvShowID : Int,
                         @Query("language") language : String) : Call<TVShow>

    @GET("3/tv/{tvShowID}/credits?api_key=$apiKey")
    fun getPeopleFromThisTVShow(@Path("tvShowID") tvShowID : Int,
                                @Query("language") language : String) : Call<PeopleFromMovieOrTVShowListResponse>



    //                                  PEOPLE SECTION
    @GET("3/search/person?api_key=$apiKey")
    fun searchForPeople(@Query("query") someText : String,
                        @Query("language") language : String) : Call<PersonListResponse>

    @GET("3/person/popular?api_key=$apiKey")
    fun getPopularPeople(@Query("language") language : String) : Call<PersonListResponse>

    @GET("3/person/{personID}?api_key=$apiKey")
    fun getPersonDetails(@Path("personID") personID : Int,
                         @Query("language") language : String) : Call<Person>

    @GET("3/person/{personID}/combined_credits?api_key=$apiKey")
    fun getMoviesAndTVShowsFromThisPerson(@Path("personID") personID : Int,
                                          @Query("language") language : String) : Call<MoviesAndTVShowsFromPersonListResponse>



    //                                  COMPANIES SECTION
    @GET("3/company/{companyID}?api_key=$apiKey")
    fun getCompanyDetails(@Path("companyID") companyID : Int,
                          @Query("language") language : String) : Call<ProductionCompany>



    //                  INSTANCE WHICH PROVIDES COMMUNICATION WITH API
    companion object {
        private const val apiKey: String = "YOUR_API_KEY"    // PLACE YOUR API KEY HERE
        private const val WEBSITE = "https://api.themoviedb.org/"
        private var INSTANCE : ApiRequest? = null

        fun getAPI() : ApiRequest {
            val tempInstance = INSTANCE
            return if (tempInstance != null) tempInstance else {
                val comm = Retrofit.Builder().baseUrl(WEBSITE)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build().create(ApiRequest::class.java)
                INSTANCE = comm
                comm
            }
        }
    }
}