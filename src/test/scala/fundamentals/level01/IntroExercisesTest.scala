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

  describe("addCurried") {

    it("1 + 2 is 3") {
      assert(addCurried(1)(2) === 3)
    }
  }

  describe("add5") {

    it("5 + 4 is 9") {
      assert(add5(4) === 9)
    }
  }

  describe("foo") {

    it("can only return the parameter unmodified (aka the 'identity' function)") {
      assert(foo(1) === 1)
    }

  }

  describe("bar") {

    it("can be any Int") {
      assert(bar(1).isInstanceOf[Int])
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
