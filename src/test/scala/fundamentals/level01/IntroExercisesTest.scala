package fundamentals.level01

import fundamentals.level01.IntroExercises._
import org.scalatest.FunSpec

class IntroExercisesTest extends FunSpec {

  describe("add") {

    it("1 + 2 is 3") {
      assert(add(1, 2) === 3)
    }

  }

  describe("curriedAdd") {

    it("1 + 2 is 3") {
      assert(curriedAdd(1)(2) === 3)
    }

  }

  describe("add5") {

    it("given 10 returns 15") {
      assert(add5(10) === 15)
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
