package fundamentals.level01

import fundamentals.level01.IntroExercises._
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec

class IntroExercisesTest extends FunSpec with TypeCheckedTripleEquals {

  describe("add") {

    it("1 + 2 is 3") {
      assert(add(1, 2) === 3)
    }

  }

  describe("timesTwoIfEven") {

    it("given 2 returns 4") {
      assert(timesTwoIfEven(2) === 4)
    }

    it("given 3 returns 3") {
      assert(timesTwoIfEven(3) === 3)
    }

  }

  describe("showNumber") {

    it("should string interpolate") {
      assert(showNumber(1) === "The number is 1")
    }

  }

}
