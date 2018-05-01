package fundamentals.level03

import fundamentals.level03.EitherExercises._
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec

class EitherExercisesTest extends FunSpec with TypeCheckedTripleEquals {

  describe("mkTrafficLightEither") {

    it("should return error message given unknown String") {
      assert(mkTrafficLightEither("bob") === Left(AppError("bob is not a valid traffic light")))
    }

    it("should return Red") {
      assert(mkTrafficLightEither("red") === Right(Red))
    }

    it("should return Yellow") {
      assert(mkTrafficLightEither("yellow") === Right(Yellow))
    }

    it("should return Green") {
      assert(mkTrafficLightEither("green") === Right(Green))
    }

  }

  describe("mkTrafficLightEitherThenShow") {

    it("should return error message given unknown String") {
      assert(mkTrafficLightEitherThenShow("bob") === "bob is not a valid traffic light")
    }

    it("should return String representation given Red") {
      assert(mkTrafficLightEitherThenShow("red") === "Traffic light is red")
    }

    it("should return String representation given Yellow") {
      assert(mkTrafficLightEitherThenShow("yellow") === "Traffic light is yellow")
    }

    it("should return String representation given Green") {
      assert(mkTrafficLightEitherThenShow("green") === "Traffic light is green")
    }

  }

  describe("mkPersonEither") {

    it("should return valid Person") {
      assert(mkPersonEither("Bob", 22) ===  Right(Person("Bob", 22)))
    }

    it("should return error message if name is blank") {
      assert(mkPersonEither("", 22) === Left(AppError("Name cannot be empty")))
    }

    it("should return error message if age < 0") {
      assert(mkPersonEither("Bob", -1) === Left(AppError("Age cannot be less than zero: -1")))
    }

  }

}
