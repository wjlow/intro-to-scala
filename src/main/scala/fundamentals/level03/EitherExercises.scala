package fundamentals.level03

import fundamentals.level02.TypesExercises.{Person, TrafficLight}
import fundamentals.level02.TypesExercises.TrafficLight._

/**
  * These exercises are optional and mirror the safe constructor exercises from `OptionExercises1.scala`
  */
object EitherExercises {

  case class AppError(msg: String)

  /**
    * scala> mkTrafficLightEither("red")
    * = Right(Red)
    *
    * scala> mkTrafficLightEither("bob")
    * = Left(AppError("bob is not a valid traffic light"))
    */
  def mkTrafficLightEither(str: String): Either[AppError, TrafficLight] = ???

  /**
    * scala> mkTrafficLightEitherThenShow("red")
    * = "Traffic light is red"
    *
    * scala> mkTrafficLightEitherThenShow("bob")
    * = "bob is not a valid traffic light"
    *
    * Hint: Use `mkTrafficLightEither` and pattern matching
    */
  def mkTrafficLightEitherThenShow(str: String): String = ???

  /**
    * scala> mkPersonEither("Bob", 22)
    * = Right(Person("Bob", 22))
    *
    * scala> mkPersonEither("Bob", -1)
    * = Left(AppError("Age cannot be less than zero: -1"))
    *
    * scala> mkPersonEither("", 22)
    * = Left(AppError("Name cannot be empty"))
    */
  def mkPersonEither(name: String, age: Int): Either[AppError, Person] = ???

}
