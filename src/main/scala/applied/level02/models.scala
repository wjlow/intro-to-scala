package applied.level02

object models {

  /**
    * Create a data type that represents what a Review is
    * 1. Author
    * 2. Comment
    */

  trait Review

  /**
    * Create a data type that represents what a Movie is
    * 1. Name
    * 2. Synopsis
    * 3. List of ReviewIds
    */

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

}