package day2.level03

object models {

  /**
    * Copy Review and Movie from level02
    */

  trait Review

  trait Movie

  /**
    * Create a List of Movies and their Reviews
    * for testing purposes
    *
    * e.g.
    *
    * val review = Review("Bob", "This is a great movie")
    * val movie = Movie("Batman Forever", "A superhero movie", List(review))
    */

  type MovieId = Int

  type ReviewId = Int

  val reviews: Map[ReviewId, Review] = ???

  val movies: Map[MovieId, Movie] = ???

  /**
    * Create an ADT that represents all valid requests:
    * 1. ListMovies
    * 2. GetReviewsForMovie
    * 3. AddMovie
    * 4. AddReviewForMovie
    *
    * What fields should these requests contain?
    */

  sealed trait AppRequest

  /**
    * Create an ADT that represents all valid responses
    *
    * There should be one for each AppRequest
    */
  sealed trait AppResponse

}