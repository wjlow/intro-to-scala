package day2.level03

import io.circe.Json
import io.circe.syntax._
import io.circe.generic.auto._

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

  val reviewsMap: mutable.Map[ReviewId, Review] = ???

  val moviesMap: mutable.Map[MovieId, Movie] = ???

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

}