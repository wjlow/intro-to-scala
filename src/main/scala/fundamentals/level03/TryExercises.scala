package fundamentals.level03

import scala.util.{Try, Success, Failure}

/**
  * These exercises use the `Try` ADT for working with code that throw exceptions (e.g. Java AWS library).
  *
  * `Try` is very similar to `Either`. Instead of having a `Right` and a `Left`, it has a `Success` and a `Failure`.
  * A value of `Try[A]` is one of `Success(a: A)` or `Failure(exception: Exception)`.
  *
  * You can think of `Try[A]` ~ `Either[Throwable, A]`
  *
  * `Try` comes with a constructor that can be used to wrap any expression that may throw an exception. We will see more of this later.
  */
object TryExercises {

  /**
    * What's wrong with this function?
    */
  def parseInt(str: String): Int = str.toInt

  /**
    * What's a safe return type?
    *
    * Expressions that throw exceptions can be surrounded by `Try`:
    *
    * ```
    * Try(mayThrowException())
    * ```
    *
    * You can pattern match of `Try` using its two constructors `Success` and `Failure`:
    *
    * ```
    * Try(mayThrowException()) match {
    * case Success(a) => // do something with `a`
    * case Failure(exception) => // do something with `exception`
    * }
    * ```
    *
    * scala> parseIntSafe("1")
    * = Success(1)
    *
    * scala> parseIntSafe("abc")
    * = Failure(java.lang.NumberFormatException: For input string: "abc")
    *
    * Hint: Use `Try` and `parseInt`
    */
  def parseIntSafe(str: String): Try[Int] = ???

  /**
    * scala> parseBooleanSafe("true")
    * = Right(true)
    *
    * scala> parseBooleanSafe("abc")
    * = Left(TryError("abc cannot be converted to Boolean"))
    **/
  def parseBooleanSafe(str: String): Try[Boolean] = ???

  /**
    * Remember that `Try[A]` ~ `Either[Throwable, A]`
    *
    * Let's write a function that converts a `Try[A]` to `Either[TryError, A]`, where `TryError` is our custom error type.
    *
    * Hint: You can convert a `Throwable` to a `String` using `.getMessage`
    */
  case class TryError(msg: String)

  def tryToEither[A](tryA: Try[A]): Either[TryError, A] =
    tryA match {
      case Success(a) => ???
      case Failure(throwable) => ???
    }


  /**
    * Create an Employee data type with three parameters:
    * 1. name: String
    * 2. age: Int
    * 3. hasDirectReports: Boolean
    *
    * Don't forget to seal it so it cannot get extended in another file!
    */

  trait Employee

  /**
    * 1. Now remove `import TryTestTypes._` from `TryExercisesTest.scala`
    * 2. Comment out the contents of `TryTestTypes`
    */

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
    * Hint: Use `parseIntSafe`, `parseBooleanSafe`, for-comprehension, `tryToEither`
    */
  def mkEmployee(csv: String): Either[TryError, Employee] =
    csv.split(",") match {
      case Array(nameStr, ageStr, hasDirectReportsStr) => ???
      case _ => Left(TryError("CSV has wrong number of fields. Expected 3."))
    }

  /**
    * @param filename Path to file containing employees data, e.g. "src/main/resources/employees.csv"
    * @return List of Employees and/or errors if any
    *
    * Hint: Use `mkEmployee`
    */
  def fileToEmployees(filename: String): List[Either[TryError, Employee]] = {
    val lines: List[String] = io.Source.fromFile(filename).getLines().toList
    ???
  }

}
