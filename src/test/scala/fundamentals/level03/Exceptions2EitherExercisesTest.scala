package fundamentals.level03

import fundamentals.level02.TypesExercises.Person
import fundamentals.level03.Exceptions2EitherExercises._
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec

class Exceptions2EitherExercisesTest extends FunSpec with TypeCheckedTripleEquals {

  describe("getName") {

    it("should return valid name if supplied") {
      assert(getName("Fred") === Right("Fred"))
    }

    it("should return an EmptyName if the name supplied is empty") {
      assert(getName("") === Left(EmptyName("provided name is empty")))
    }

    it("should return an EmptyName if the name supplied contains only spaces") {
      assert(getName("          ") === Left(EmptyName("provided name is empty")))
    }
  }

  describe("getAge") {

    it("should return valid age if supplied") {
      assert(getAge("20") === Right(20))
    }

    it("should return an InvalidAgeValue if the age supplied is not an Int") {
      assert(getAge("Fred") === Left(InvalidAgeValue("provided age is invalid: Fred")))
    }

    it("should return an InvalidAgeRange if the age supplied is not between 1 and 120") {
      assert(getAge("-1") === Left(InvalidAgeRange("provided age should be between 1-120: -1")))
    }
  }

  describe("createPerson") {

    it("should return Person if supplied a valid name and age") {
      assert(createPerson("Fred", "32") === Right(Person("Fred", 32)))
    }

    it("should return an EmptyName if the name supplied is empty") {
      assert(createPerson("", "32") === Left(EmptyName("provided name is empty")))
    }

    it("should return an InvalidAgeValue if the age supplied is not an Int") {
      assert(createPerson("Fred", "ThirtyTwo") === Left(InvalidAgeValue("provided age is invalid: ThirtyTwo")))
    }

    it("should return an InvalidAgeRange if the age supplied is not between 1 and 120") {
      assert(createPerson("Fred", "150") === Left(InvalidAgeRange("provided age should be between 1-120: 150")))
    }
  }

  describe("createValidPeople") {

    it("should return a List Person instances") {
      assert(createValidPeople === List(Person("Tokyo", 30), Person("Berlin", 43)))
    }
  }

  describe("collectErrors") {

    it("should return a List of errors returned while processing inputs") {
      assert(collectErrors === List(InvalidAgeValue("provided age is invalid: 5o"),
                                    InvalidAgeRange("provided age should be between 1-120: 200"),
                                    InvalidAgeRange("provided age should be between 1-120: 0"),
                                    EmptyName("provided name is empty")))
    }
  }
}
