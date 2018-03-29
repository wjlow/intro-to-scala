package fundamentals.level03

import scala.util.{Try, Success, Failure}

/**
  * Complete `OptionExercises.scala` and `EitherExercises.scala` before this
  */
object TryExercises {

  /**
    * What's wrong with this function?
    */
  def parseInt(str: String): Int = str.toInt

  /**
    * This is a tiny type on `Int` to be used in `parseAge`
    */
  case class Age(value: Int)

  /**
    * What can go wrong if we implement this using `parseInt`?
    */
  def parseAge(str: String): Age = ???

  /**
    * What's a safe return type?
    *
    * Hint: Use pattern matching
    */
  def parseIntSafe(str: String) = ???

  def parseIntSafeEither(str: String) = ???

  /**
    * scala> parseBooleanSafeEither("true")
    * = Right(true)
    *
    * scala> parseBooleanSafeEither("abc")
    * = Left(AppError("abc cannot be converted to Boolean"))
    */
  def parseBooleanSafeEither(str: String) = ???

  /**
    * Create an Employee data type with three parameters:
    * 1. name: String
    * 2. age: Int
    * 3. hasDirectReports: Boolean
    */

  trait Employee

  case class TryError(msg: String)

  /**
    * Create a CSV parser to safely create an Employee
    *
    * Start by filling out the return type
    *
    * scala> mkEmployee("Bob,22,true")
    * = Right(Employee("Bob", 22, true))
    *
    * scala> mkEmployee("Bob,abc,true")
    * = Left(TryError("abc cannot be converted to Int"))
    *
    * scala> mkEmployee("Bob,22,abc")
    * = Left(TryError("abc cannot be converted to Boolean"))
    *
    * Hint: Use csv.split(","), parseIntSafeEither and parseBooleanSafeEither
    */
  def mkEmployee(csv: String): Either[TryError, Employee] = ???

  /**
    * @param filename Path to file containing employees data, e.g. "src/main/resources/employees.csv"
    * @return List of Employees and/or errors if any
    *
    * Hint: Use `mkEmployee`
    */
  def fileToEmployees(filename: String): List[Either[TryError, Employee]] = ???

}
