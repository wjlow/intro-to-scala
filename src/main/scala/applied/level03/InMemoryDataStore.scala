package applied.level03

import cats.effect.IO
import applied.level03.models._

/**
  * A DataStore implementation that uses sample data from `models.scala`
  */
object InMemoryDataStore extends DataStore {

  override def listMovies(): IO[Either[String, List[Movie]]] =
    IO {
      ???
    }

  override def getReviews(movieId: MovieId): IO[Either[String, List[Review]]] =
    IO {
      ???
    }

  override def addMovie(name: String, desc: String): IO[Either[String, MovieId]] =
    IO {
      ???
    }

  override def addReview(movieId: MovieId, author: String, comment: String): IO[Either[String, ReviewId]] =
    IO {
      ???
    }

}
