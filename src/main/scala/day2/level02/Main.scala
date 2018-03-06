package day2.level02

import day2.level02.models.Movie

import cats.effect._
import io.circe._

import fs2.StreamApp.ExitCode
import fs2._

import org.http4s._
import org.http4s.dsl.io._
import org.http4s.server.blaze._

import scala.concurrent.ExecutionContext.Implicits.global

object Main extends StreamApp[IO] {

  override def stream(args: List[String], requestShutdown: IO[Unit]): Stream[IO, ExitCode] =
    BlazeBuilder[IO]
      .bindHttp(8080, "localhost")
      .mountService(service, "/")
      .serve

  /**
    * Copy your routes from level01 and update them to return sample data from `models.scala` as Json.
    * Don't worry about returning the right data for now, just get it to compile and return some Json.
    *
    * Make sure you set the following headers:
    *
    * 1. `Content-Type: application/json`
    */
  val service: HttpService[IO] = HttpService[IO] {
    case GET -> Root / "movies" => ???
  }

}
