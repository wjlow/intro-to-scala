package fundamentals.level03

import fundamentals.level03.EitherExercises.AppError
import fundamentals.level03.TryExercises._
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec

class TryExercisesTest extends FunSpec with TypeCheckedTripleEquals {

  describe("parseIntSafe") {

    it("should return ??? given not an Int") {
      assert(parseIntSafe("bob") == ???)
    }

    it("should return Int") {
      assert(parseIntSafe("123") == ???)
    }

  }

  describe("parseIntSafeEither") {

    it("should return ??? given not an Int") {
      assert(parseIntSafeEither("bob") == ???)
    }

    it("should return Int") {
      assert(parseIntSafeEither("123") == ???)
    }

  }

  describe("parseBooleanSafeEither") {

    it("should return error message given not a Boolean") {
      assert(parseBooleanSafeEither("bob") == ???)
    }

    it("should return true") {
      assert(parseBooleanSafeEither("true") == ???)
    }

    it("should return false") {
      assert(parseBooleanSafeEither("false") == ???)
    }

  }

  describe("mkEmployee") {

    it("should return valid Employee") {
      assert(mkEmployee("Bob,22,true") == ???)
    }

    it("should return error message if age is not a number") {
      assert(mkEmployee("Bob,abc,true") == ???)
    }

    it("should return error message if hasDirectReports is not a Boolean") {
      assert(mkEmployee("Bob,22,abc") == ???)
    }

  }

  describe("fileToEmployees") {

    it("should return first error if any") {
      val errorOrEmployees = fileToEmployees("src/main/resources/employees.csv")
      errorOrEmployees === List(
        Right(???),
        Right(???),
        Right(???),
        Left(TryError("xx cannot be converted to Int")),
        Left(TryError("yes cannot be converted to Boolean")))
    }

  }

}
