package day2.level03

import cats.effect.IO
import day2.level03.models._

/**
  * A DataStore implementation that uses sample data from `scala`
  */
object InMemoryDataStore extends DataStore {

  override def listMovies(): IO[Either[String, List[Movie]]] = IO.pure(Right(moviesMap.values.toList))

  override def getReviews(movieId: MovieId): IO[Either[String, List[Review]]] = ???

  override def addMovie(name: String, desc: String): IO[Either[String, MovieId]] =
    IO {
      execAddMovie(name, desc)
    }

  private def execAddMovie(name: String, desc: String) = {
    val movie = Movie(name, desc, Nil)
    latestMovieId += 1
    moviesMap.put(latestMovieId, movie)
    Right(latestMovieId)
  }

  override def addReview(movieId: MovieId, author: String, comment: String): IO[Either[String, ReviewId]] =
    IO {
      for {
        newReviewId <- execAddReview(author, comment)
        movie <- execGetMovie(movieId)
      } yield {
        val updatedMovie = movie.copy(reviews = movie.reviews :+ newReviewId)
        moviesMap.update(movieId, updatedMovie)
        latestReviewId
      }
    }

  private def execGetMovie(movieId: MovieId) =
    moviesMap.get(movieId).toRight(s"Movie $movieId not found")

  private def execAddReview(author: String, comment: String) = {
    latestReviewId += 1
    val review = Review(author, comment)
    reviewsMap.put(latestReviewId, review)
    Right(latestReviewId)
  }
}
