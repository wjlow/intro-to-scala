package day2.level03

import cats.effect.IO
import day2.level03.models._

/**
  * A DataStore implementation that uses sample data from `scala`
  */
object InMemoryDataStore extends DataStore {

  override def listMovies(): IO[Either[String, List[Movie]]] = ???

  override def getReviews(movieId: MovieId): IO[Either[String, List[Review]]] = ???

  override def addMovie(name: String, desc: String): IO[Either[String, Unit]] = ???

  override def addReview(movieId: MovieId, author: String, comment: String): IO[Either[String, Unit]] = ???

}
