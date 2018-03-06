package day2.level03

import io.circe.Json
import io.circe.syntax._
import io.circe.generic.auto._

import scala.collection.mutable

object models {

  /**
    * Copy Review and Movie from level02
    */

  case class Review(author: String, comment: String)

  case class Movie(name: String, desc: String, reviews: List[ReviewId])

  /**
    * Create a Map of Movies and their Reviews so our app can read from these as the DataStore for this level.
    * We can worry about integrating with a real database later on.
    *
    * We are using mutable Map here so we can add to the Map while the app is running through the POST endpoints.
    */

  type MovieId = Int

  type ReviewId = Int

  var latestReviewId = 0

  var latestMovieId = 0

  val reviewsMap: mutable.Map[ReviewId, Review] = mutable.Map()

  val moviesMap: mutable.Map[MovieId, Movie] = mutable.Map()

  /**
    * Create an ADT that represents all valid requests:
    * 1. ListMovies
    * 2. GetReviews
    * 3. AddMovie
    * 4. AddReview
    *
    * What fields should these requests contain?
    */

  sealed trait AppRequest
  case object ListMovies extends AppRequest
  case class AddMovie(name: String, desc: String) extends AppRequest

  /**
    * Create an ADT that represents all possible responses
    *
    * There should be one for each AppRequest. Do each of them have a possibility of failure?
    */
  sealed trait AppResponse
  case class ListMoviesResp(result: List[Movie]) extends AppResponse
  case class AddMovieResp(result: Movie) extends AppResponse

  /**
    * Write a function that converts an AppResponse to a Json
    *
    * Error cases should be converted to Json too
    *
    * Hint: Pattern match on `appResponse`
    */
  def appResponseToJson(appResponse: AppResponse): Json = appResponse match {
    case ListMoviesResp(movies) => movies.asJson
    case AddMovieResp(movie) => movie.asJson
  }

  def errorToJson(str: String): Json =
    Json.obj("msg" -> str.asJson)

}