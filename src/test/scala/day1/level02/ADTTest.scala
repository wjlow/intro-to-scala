package day1.level02

import day1.level02.ADT._
import org.scalatest.FunSpec

class ADTTest extends FunSpec {

  describe("printPerson") {

    it("should turn Bob into a String") {
      val person = Person("Bob", 50)

      val str = printPerson(person)

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

  describe("printTrafficLight") {

    it("should print Red") {
      val str = printTrafficLight(Red)

      assert(str === "The traffic light is red")
    }

    // TODO: Write unit tests for Yellow and Green

  }


}
