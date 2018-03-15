package day2.level03

import cats.effect.IO

import io.circe._
import io.circe.generic.auto._
import io.circe.syntax._

import org.http4s._
import org.http4s.circe._
import org.http4s.dsl.io._

import scala.collection.mutable

object models {

  /**
    * Copy Review and Movie from level02
    */

  trait Review

  trait Movie

  /**
    * Create a Map of Movies and their Reviews so our app can read from these as the DataStore for this level.
    * We can worry about integrating with a real database later on.
    *
    * We are using mutable Map here so we can add to the Map while the app is running through the POST endpoints.
    */

  type MovieId = Int

  type ReviewId = Int

  /**
    * We are creating an in memory store here, with an Id counter that we will increment each time we add to the store.
    */
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

  /**
    * Create an ADT that represents all possible responses
    *
    * There should be one for each AppRequest. Do each of them have a possibility of failure?
    */
  sealed trait AppResponse

  /**
    * Write a function that converts an AppResponse to a Json
    *
    * Error cases should be converted to Json too
    *
    * Hint: Pattern match on `appResponse`
    */
  def appResponseToJson(appResponse: AppResponse): Json = ???

  /**
    * Create a data type that holds an error message. This is the main error type we will be using in the entire application.
    */
  trait AppError

}