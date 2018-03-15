package day1.level01

import org.scalacheck._
import org.scalatest.FunSpec
import org.scalatest.prop.PropertyChecks
import Intro._

class Level01Test extends FunSpec with PropertyChecks {

  describe("add") {

    it("(x + y) is the same as (y + x)") {

      forAll { (x: Int, y: Int) =>
        assert(add(x, y) === add(y, x))
      }

    }

    it("(x + 1 + 1) is the same as (x + 2)") {

      forAll { (x: Int) =>
        assert(add(add(x, 1), 1) === add(x, 2))
      }

    }

    it("(x + 0) is the same as x") {

      forAll { (x: Int) =>
        assert(add(x, 0) === x)
      }

    }

  }

  describe("timesTwoIfEven") {

    it("should multiply by 2 only if the number is even") {

      val evenNumbers = Gen.choose(0, 1000).suchThat(x => x % 2 === 0)
      forAll(evenNumbers) { (x: Int) =>
        assert(timesTwoIfEven(x) === x * 2)
      }

    }

    it("should not do anything if the number is not even") {

      val oddNumbers = Gen.choose(0, 1000).suchThat(x => x % 2 != 0)
      forAll(oddNumbers) { (x: Int) =>
        assert(timesTwoIfEven(x) === x)
      }

    }

  }

  describe("printNumber") {

    it("should string interpolate") {

      forAll { (x: Int) =>
        assert(printNumber(x) === s"The number is $x")
      }

    }

  }

}
