package day2.level03

import day2.level03.models._

import cats.effect._

import fs2.StreamApp
import fs2.StreamApp.ExitCode

import org.http4s._
import org.http4s.dsl.io._
import org.http4s.server.blaze._
import org.http4s.circe._

import io.circe.generic.auto._
import io.circe.syntax._
import io.circe._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Try

object Main extends StreamApp[IO] {

  override def stream(args: List[String], requestShutdown: IO[Unit]): fs2.Stream[IO, ExitCode] =
    BlazeBuilder[IO]
      .bindHttp(8080, "localhost")
      .mountService(service, "/")
      .serve

  /**
    * Copy your routes from level02 and update them to interact with `reviewsMap` and `moviesMap`
    * from `models.scala`.
    *
    * Hint: Use Controller.handleRequest and appResponseToJson
    *
    * Start by creating a Controller that uses an implementation of the `InMemoryDataStore`
    */
  val controller: Controller = new Controller(InMemoryDataStore)

  val service: HttpService[IO] = HttpService[IO] {
    case GET -> Root / "movies" => listMovies
    case GET -> Root / "movies" / movieId => getReviews(movieId)
    case req@POST -> Root / "movies" => addMovie(req)
    case req@POST -> Root / "movie" / movieId / "reviews" => addReview(req, movieId)
  }

  private def listMovies = {
    val req = ListMoviesReq
    controller.handle(req)
  }

  private def getReviews(movieId: String) =
    Try(movieId.toInt).toOption match {
      case None => BadRequest("movieId cannot be converted to Int")
      case Some(num) =>
        val req = GetReviewsReq(num)
        controller.handle(req)
    }

  private def addMovie(req: Request[IO]) =
    for {
      req <- req.as[AddMovieReq]
      response <- controller.handle(req)
    } yield response

  private def addReview(req: Request[IO], movieId: String) =
    Try(movieId.toInt).toOption match {
      case None => BadRequest("movieId cannot be converted to Int")
      case Some(num) =>
        for {
          reviewToAdd <- req.as[ReviewToAdd]
          req = AddReviewReq(num, reviewToAdd)
          response <- controller.handle(req)
        } yield response
    }
}

