package fundamentals.level01

import fundamentals.level01.IntroExercises._
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec

class IntroExercisesTest extends FunSpec with TypeCheckedTripleEquals {

  describe("add") {

    it("1 + 2 is 3") {
      assert(add(1, 2) === 3)
    }

    it("5 + 7 is 12") {
      assert(add(5, 7) === 12)
    }

  }

  describe("addCurried") {

    it("1 + 2 is 3") {
      assert(addCurried(1)(2) === 3)
    }

    it("5 + 7 is 12") {
      assert(addCurried(5)(7) === 12)
    }

  }

  describe("add5") {

    it("5 + 4 is 9") {
      assert(add5(4) === 9)
    }
    it("10 + 5 is 15") {
      assert(add5(10) === 15)
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

  describe("pair") {

    it("Jimmy and 25") {
      assert(pair("Jimmy", 25) === ("Jimmy", 25))
    }

    it("Sammy and 30") {
      assert(pair("Sammy", 30) === ("Sammy", 30))
    }
  }

  describe("fst") {

    it("Jimmy and 25") {
      assert(fst("Jimmy", 25) === "Jimmy")
    }

    it("Sammy and 30") {
      assert(fst("Sammy", 30) === "Sammy")
    }
  }

  describe("snd") {

    it("Jimmy and 25") {
      assert(snd("Jimmy", 25) === 25)
    }

    it("Sammy and 30") {
      assert(snd("Sammy", 30) === 30)
    }
  }

}
