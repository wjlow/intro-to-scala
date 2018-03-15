package day2.level03

import day2.level03.models._

import cats.effect.IO

import org.http4s._
import org.http4s.dsl.io._
import org.http4s.circe._

class Controller(dataStore: DataStore) {

  def handle(appRequest: AppRequest): IO[Response[IO]] = ???

  /**
    * Call functions defined on `DataStore` and construct an `AppResponse` for each possible `AppRequest`
    *
    * Hint: Pattern match on `appRequest`
    */
  private[level03] def requestToResponse(appRequest: AppRequest): IO[Either[String, AppResponse]] = ???
}
