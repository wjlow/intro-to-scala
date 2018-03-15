package day1.level02

import org.scalacheck._
import org.scalatest.FunSpec
import org.scalatest.prop.PropertyChecks
import ADT._

class ADTTest extends FunSpec {

  describe("printPerson") {

    it("should turn Bob into a String") {
      // given
      val person = Person("Bob", 50)

      // when
      val str = printPerson(person)

      // then
      assert(str === "Bob is 50 years old")
    }

  }

  describe("changeName") {

    it("should update the Person's name") {
      // given
      val person = Person("Bob", 50)

      // when
      val updatedPerson = changeName("Sarah", person)

      // then
      assert(updatedPerson === Person("Sarah", 50))
      assert(person === Person("Bob", 50)) // assertion is unnecessary, but shows immutability
    }

  }

  describe("printTrafficLight") {

    it("should print Red") {
      // when
      val str = printTrafficLight(Red)

      // then
      assert(str === "The traffic light is red")
    }

    // TODO: Write unit tests for Yellow and Green

  }


}
