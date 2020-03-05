package introcourse.level02

import introcourse.level02.TypesExercises._
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.funspec.AnyFunSpec

class TypesExercisesTest extends AnyFunSpec with TypeCheckedTripleEquals {

  describe("showPerson1") {

    it("should turn Bob into a String") {
      val person = Person("Bob", 50)

      val str = showPerson1(person)

      assert(str === "Bob is 50 years old")
    }

  }

  describe("showPerson2") {

    it("should turn Bob into a String") {
      val person = Person("Bob", 50)

      val str = showPerson2(person)

      assert(str === "Bob is 50 years old")
    }

  }

  describe("changeName") {

    it("should update the Person's name") {
      val person = Person("Bob", 50)

      val updatedPerson = changeName("Sarah", person)

      assert(updatedPerson === Person("Sarah", 50))
      assert(person === Person("Bob", 50)) // assertion is unnecessary, but shows immutability
    }

  }

  describe("showWallet") {

    it("should show the wallet amount as a String") {
      val wallet = Wallet(23.4)

      val str = showWallet(wallet)

      assert(str === "The wallet amount is 23.4")
    }

  }

  describe("purchase") {

    it("should return a wallet with cost deducted") {
      val wallet = Wallet(100)

      val updatedWallet = purchase(25, wallet)

      assert(updatedWallet === Wallet(75))
      assert(wallet === Wallet(100)) // `wallet` hasn't been mutated
    }

  }

  describe("showTrafficLightStr") {

    it("should show red") {
      val str = showTrafficLightStr("red")

      assert(str === "The traffic light is red")
    }

    it("should show yellow") {
      val str = showTrafficLightStr("yellow")

      assert(str === "The traffic light is yellow")
    }

    it("should show green") {
      val str = showTrafficLightStr("green")

      assert(str === "The traffic light is green")
    }

    it("should return a default on other inputs") {
      ???
    }

    it("should show flashing") {
      ???
    }

  }

  describe("showTrafficLight") {

    it("should show Red") {
      val str = showTrafficLight(Red)

      assert(str === "The traffic light is red")
    }

    it("should show Yellow") {
      val str = showTrafficLight(Yellow)

      assert(str === "The traffic light is yellow")
    }

    it("should show Green") {
      val str = showTrafficLight(Green)

      assert(str === "The traffic light is green")
    }

    it("should show Flashing") {
      ???
    }

  }


}
