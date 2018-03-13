package day2.level03

import day2.level03.models._

import cats.effect.IO

import org.http4s._
import org.http4s.dsl.io._
import org.http4s.server.blaze._
import org.http4s.circe._

class Controller(dataStore: DataStore) {

  def handle(appRequest: AppRequest): IO[Response[IO]] =
    requestToResponse(appRequest).flatMap {
      case Right(appResponse) => Ok(appResponseToJson(appResponse))
      case Left(err) => InternalServerError(errorToJson(err))
    }

  /**
    * Call functions defined on `DataStore` and construct an `AppResponse` for each possible `AppRequest`
    *
    * Hint: Pattern match on `appRequest`
    */
  private[level03] def requestToResponse(appRequest: AppRequest): IO[Either[String, AppResponse]] =
    appRequest match {
      case ListMovies => dataStore.listMovies().map(_.map(ListMoviesResp))
      case AddMovie(name, desc) => dataStore.addMovie(name, desc).map(_.map(AddMovieResp))
      case AddReview(movieId, AddReviewPayload(author, comment)) => dataStore.addReview(movieId, author, comment).map(_.map(AddReviewResp))
    }

}
