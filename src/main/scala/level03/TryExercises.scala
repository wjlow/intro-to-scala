package level03

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
    * What's a safe return type?
    *
    * Hint: Use pattern matching
    */
  def parseIntSafe1(str: String) = ???

  /**
    * Same as above but use .map and .left.map
    */
  def parseIntSafe2(str: String) = ???

  /**
    * Create an Employee data type with three parameters:
    * 1. name: String
    * 2. age: Int
    * 3. hasDirectReports: Boolean
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
    * Hint: Use csv.split(",")
    */
  def mkEmployee(csv: String) = ???

}
