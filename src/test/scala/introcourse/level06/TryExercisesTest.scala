package introcourse.level06

import introcourse.level06.TryTestTypes._
import introcourse.level06.TryExercises._

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.funspec.AnyFunSpec

import scala.util.{Failure, Success}

class TryExercisesTest extends AnyFunSpec with TypeCheckedTripleEquals {

  describe("parseIntSafe") {

    it("should return Failure given not an Int") {
      assert(parseIntSafe("abc").isFailure === true)
    }

    it("should return Success given an Int") {
      assert(parseIntSafe("123") === Success(123))
    }

  }

  describe("parseBooleanSafe") {

    it("should return Failure given not a Boolean") {
      assert(parseBooleanSafe("abc").isFailure === true)
    }

    it("should return Success given true") {
      assert(parseBooleanSafe("true") === Success(true))
    }

    it("should return Success given false") {
      assert(parseBooleanSafe("false") === Success(false))
    }

  }

  describe("increment") {

    it("should increment the given number") {
      assert(increment("5") === Success(6))
    }

    it("should return Failure given not a number") {
      assert(increment("NaN").isFailure === true)
    }
  }

  private case class CustomException(msg: String) extends Throwable {
    override def getMessage: String = msg
  }

  describe("tryToEither") {

    it("should return Right given Success") {
      assert(tryToEither(Success("abc")) === Right("abc"))
    }

    it("should return Left given Failure") {

      assert(tryToEither(Failure(CustomException("msg"))) === Left(TryError("msg")))
    }
  }

  describe("tryToOption") {

    it("should return Some given Success") {
      assert(tryToOption(Success("abc")) === Some("abc"))
    }

    it("should return None given Failure") {
      assert(tryToOption(Failure(CustomException("msg"))) === None)
    }
  }

  describe("mkEmployee") {

    it("should return valid Employee in a Right") {
      assert(mkEmployee("Bob,22,true") == Right(Employee("Bob", 22, true)))
    }

    it("should return Left if age is not a number") {
      assert(mkEmployee("Bob,abc,true") === Left(TryError("""For input string: "abc"""")))
    }

    it("should return Left if hasDirectReports is not a Boolean") {
      assert(mkEmployee("Bob,22,abc") === Left(TryError("""For input string: "abc"""")))
    }

    it("should return Left if csv does not have 3 fields") {
      assert(mkEmployee("a,b,c,d") === Left(TryError("CSV has wrong number of fields. Expected 3.")))
    }

  }

  describe("fileToEmployees") {

    it("should return first error if any") {
      val errorOrEmployees = fileToEmployees("src/main/resources/employees.csv")

      assert(errorOrEmployees == List(
        Right(Employee("ophelia", 25, false)),
        Right(Employee("romeo", 30, false)),
        Right(Employee("juliet", 29, true)),
        Left(TryError("""For input string: "xx"""")),
        Left(TryError("""For input string: "yes""""))))
    }

  }

}
