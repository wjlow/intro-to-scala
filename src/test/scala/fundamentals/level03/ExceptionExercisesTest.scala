package fundamentals.level03

import fundamentals.level02.TypesExercises.Person
import fundamentals.level03.ExceptionExercises._
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec

class ExceptionExercisesTest extends FunSpec with TypeCheckedTripleEquals {

  describe("getName") {

    it("should return valid name if supplied") {
      assert(getName("Fred") === "Fred")
    }

    it("should throw an EmptyNameException if the name supplied is empty") {
      val caught = intercept[EmptyNameException] {
        getName("")
      }

      assert(caught.getMessage === "provided name is empty")
    }

    it("should throw an EmptyNameException if the name supplied contains only spaces") {
      val caught = intercept[EmptyNameException] {
        getName("          ")
      }

      assert(caught.getMessage === "provided name is empty")
    }
  }

  describe("getAge") {

    it("should return valid age if supplied") {
      assert(getAge("20") === 20)
    }

    it("should throw an InvalidAgeValueException if the age supplied is not an Int") {
      val caught = intercept[InvalidAgeValueException] {
        getAge("Fred")
      }

      assert(caught.getMessage === "provided age is invalid: Fred")
    }

    it("should throw an InvalidAgeRangeException if the age supplied is not between 1 and 120") {
      val caught = intercept[InvalidAgeRangeException] {
        getAge("-1")
      }

      assert(caught.getMessage === "provided age should be between 1-120: -1")
    }
  }

  describe("createPerson") {

    it("should return Person if supplied a valid name and age") {
      assert(createPerson("Fred", "32") === Person("Fred", 32))
    }

    it("should throw an EmptyNameException if the name supplied is empty") {
      val caught = intercept[EmptyNameException] {
        createPerson("", "32")
      }

      assert(caught.getMessage === "provided name is empty")
    }

    it("should throw an InvalidAgeValueException if the age supplied is not an Int") {
      val caught = intercept[InvalidAgeValueException] {
        createPerson("Fred", "ThirtyTwo")
      }

      assert(caught.getMessage === "provided age is invalid: ThirtyTwo")
    }

    it("should throw an InvalidAgeRangeException if the age supplied is not between 1 and 120") {
      val caught = intercept[InvalidAgeRangeException] {
        createPerson("Fred", "150")
      }

      assert(caught.getMessage === "provided age should be between 1-120: 150")
    }
  }

  describe("validPairs") {

    it("should return a List of valid name and age pairs") {
      assert(validPairs === List(("Tokyo", "30"), ("Berlin", "43")))
    }
  }

  describe("createValidPeople") {

    it("should return a List Person instances") {
      assert(createValidPeople === List(Person("Tokyo", 30), Person("Berlin", 43)))
    }
  }

  describe("createValidPeople2") {

    it("should return a List Person instances") {
      assert(createValidPeople2 === List(Person("Tokyo", 30), Person("Berlin", 43)))
    }
  }

  describe("collectErrors") {

    it("should return a List Exceptions thrown while processing inputs") {

      def exceptionEq(e1: Exception, e2: Exception): Boolean =
        e1.getClass == e2.getClass && e1.getMessage == e2.getMessage

      val expectedErrors = List(new InvalidAgeValueException("provided age is invalid: 5o"),
                                    new InvalidAgeRangeException("provided age should be between 1-120: 200"),
                                    new InvalidAgeRangeException("provided age should be between 1-120: 0"),
                                    new EmptyNameException("provided name is empty"))
      collectErrors.zip(expectedErrors).foreach {
        case (e1, e2) => assert(exceptionEq(e1, e2), s"$e1 != $e2")
      }
    }
  }
}
