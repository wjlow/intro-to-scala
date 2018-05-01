package fundamentals.level03

import TryTestTypes._
import fundamentals.level03.TryExercises._
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec

import scala.util.Success

/**
  * The assertions in this file are intentionally left blank for you to fill in.
  */
class TryExercisesTest extends FunSpec with TypeCheckedTripleEquals {

  describe("parseIntSafe") {

    it("should return TryError given not an Int") {
      assert(parseIntSafe("abc").isFailure === true)
    }

    it("should return Int") {
      assert(parseIntSafe("123") === Success(123))
    }

  }

  describe("parseBooleanSafe") {

    it("should return error message given not a Boolean") {
      assert(parseBooleanSafe("abc").isFailure === true)
    }

    it("should return true") {
      assert(parseBooleanSafe("true") === Success(true))
    }

    it("should return false") {
      assert(parseBooleanSafe("false") === Success(false))
    }

  }

  describe("mkEmployee") {

    it("should return valid Employee") {
      assert(mkEmployee("Bob,22,true") == Right(Employee("Bob", 22, true)))
    }

    it("should return error message if age is not a number") {
      assert(mkEmployee("Bob,abc,true").isLeft === true)
    }

    it("should return error message if hasDirectReports is not a Boolean") {
      assert(mkEmployee("Bob,22,abc").isLeft === true)
    }

    it("should return error message if csv does not have 3 fields") {
      assert(mkEmployee("a,b,c,d").isLeft === true)
    }

  }

  describe("fileToEmployees") {

    it("should return first error if any") {
      val errorOrEmployees = fileToEmployees("src/main/resources/employees.csv")
      errorOrEmployees == List(
        Right(Employee("ophelia", 25, false)),
        Right(Employee("romeo", 30, false)),
        Right(Employee("juliet", 29, true)),
        Left(TryError("xx cannot be converted to Int")),
        Left(TryError("yes cannot be converted to Boolean")))
    }

  }

}
