package day2.level01

import cats.effect._

import fs2.StreamApp
import fs2.StreamApp.ExitCode

import org.http4s._
import org.http4s.dsl.io._
import org.http4s.server.blaze._

import scala.concurrent.ExecutionContext.Implicits.global

object Main extends StreamApp[IO] {

  override def stream(args: List[String], requestShutdown: IO[Unit]): fs2.Stream[IO, ExitCode] =
    BlazeBuilder[IO]
      .bindHttp(8080, "localhost")
      .mountService(service, "/")
      .serve

  /**
    * Create routes for your application with hard-coded responses
    *
    * GET  /movies
    *   returns: All movies, OK 200
    * GET  /movie/1/reviews
    *   returns: All reviews for movie with id 1, OK 200
    * POST /movies/
    *   payload: { "name": "Batman Forever", "synopsis": "Superhero movie!" }
    *   returns: Created 201
    * POST /movie/1/reviews
    *   payload: { "author": "Bob", "comment": "Great movie for the family." }
    *   returns: Created 201
    *
    * Don't worry if the word `service` is highlighted red in IntelliJ.
    */
  val service: HttpService[IO] = HttpService[IO] {
    case GET -> Root / "movies" => ???
  }

}
