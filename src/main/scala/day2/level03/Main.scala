package day2.level03

import cats.effect._
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
    * Use `Controller.scala` to retrieve sample data
    */
  val service: HttpService[IO] = HttpService[IO] {
    case GET -> Root / "movies" => ???
  }

}
