package fundamentals.level03

import scala.util.{Try, Success, Failure}

/**
  * These exercises use the `Try` ADT for working with code that throw exceptions (e.g. Java AWS library).
  *
  * `Try` is very similar to `Either`. Instead of having a `Right` and a `Left`, it has a `Success` and a `Failure`.
  * A value of `Try[A]` is one of `Success(a: A)` or `Failure(exception: Exception)`.
  *
  * `Try` comes with a constructor that can be used to wrap any expression that may throw an exception. We will see more of this later.
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
    *   case Success(a) => // do something with `a`
    *   case Failure(exception) => // do something with `exception`
    * }
    * ```
    *
    * Hint: Use `Try` and pattern matching to solve this. `Try` also has a method `.toOption` that may help.
    */
  def parseIntSafe(str: String) = ???

  /**
    * Let's introduce a custom error type for the rest of these exercises.
    */
  case class TryError(msg: String)

  /**
    * Let's write another version of `parseIntSafe` that retains some error information.
    *
    * scala> parseIntSafeEither("123")
    * = Right(123)
    *
    * scala> parseIntSafeEither("bob")
    * = Left(TryError("bob cannot be converted to Int"))
    */
  def parseIntSafeEither(str: String): Either[TryError, Int] = ???

  /**
    * scala> parseBooleanSafeEither("true")
    * = Right(true)
    *
    * scala> parseBooleanSafeEither("abc")
    * = Left(TryError("abc cannot be converted to Boolean"))
    */
  def parseBooleanSafeEither(str: String): Either[TryError, Boolean] = ???

  /**
    * Create an Employee data type with three parameters:
    * 1. name: String
    * 2. age: Int
    * 3. hasDirectReports: Boolean
    */

  trait Employee

  /**
    * Now remove `import TryTestTypes._` from `TryExercisesTest.scala`
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
