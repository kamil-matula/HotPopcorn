package com.example.hotpopcorn.model.responses

import com.example.hotpopcorn.model.GeneralObject

// Used in person details - consists of lists of movies and tv shows that specific person performed in or was in crew:
class MoviesAndTVShowsFromPersonListResponse(val id : Int, val cast : List<GeneralObject>, val crew : List<GeneralObject>)