package day1.level01

import day1.level01.Intro._
import org.scalatest.FunSpec

class Level01Test extends FunSpec {

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

  describe("printNumber") {

    it("should string interpolate") {
      assert(printNumber(1) === "The number is 1")
    }

  }

}
