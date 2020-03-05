package introcourse.level05

import introcourse.level05.EitherExercises._
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.funspec.AnyFunSpec

class EitherExercisesTest extends AnyFunSpec with TypeCheckedTripleEquals {

  describe("getName") {

    it("should return valid name if supplied") {
      assert(getName("Fred") === Right("Fred"))
    }

    it("should return an EmptyName if the name supplied is empty") {
      assert(getName("") === Left(EmptyName))
    }

  }

  describe("getAge") {

    it("should return valid age if supplied") {
      assert(getAge("20") === Right(20))
    }

    it("should return an InvalidAgeValue if the age supplied is not an Int") {
      assert(getAge("Fred") === Left(InvalidAgeValue("Fred")))
    }

    it("should return an InvalidAgeRange if the age supplied is not between 1 and 120") {
      assert(getAge("-1") === Left(InvalidAgeRange(-1)))
    }

    it("should return an InvalidAgeRange if the age supplied is 0") {
      assert(getAge("0") === Left(InvalidAgeRange(0)))
    }

    it("should accept age of one") {
      assert(getAge("1") == Right(1))
    }

    it("should accept ages of a hundred and twenty") {
      assert(getAge("120") == Right(120))
    }

  }

  describe("createPerson") {

    it("should return Person if supplied a valid name and age") {
      assert(createPerson("Fred", "32") === Right(Person("Fred", 32)))
    }

    it("should return an EmptyName if the name supplied is empty") {
      assert(createPerson("", "32") === Left(EmptyName))
    }

    it("should return an InvalidAgeValue if the age supplied is not an Int") {
      assert(createPerson("Fred", "ThirtyTwo") === Left(InvalidAgeValue("ThirtyTwo")))
    }

    it("should return an InvalidAgeRange if the age supplied is not between 1 and 120") {
      assert(createPerson("Fred", "150") === Left(InvalidAgeRange(150)))
    }
  }

  describe("createPerson2") {

    it("should return Person if supplied a valid name and age") {
      assert(createPerson2("Fred", "32") === Right(Person("Fred", 32)))
    }

    it("should return an EmptyName if the name supplied is empty") {
      assert(createPerson2("", "32") === Left(EmptyName))
    }

    it("should return an InvalidAgeValue if the age supplied is not an Int") {
      assert(createPerson2("Fred", "ThirtyTwo") === Left(InvalidAgeValue("ThirtyTwo")))
    }

    it("should return an InvalidAgeRange if the age supplied is not between 1 and 120") {
      assert(createPerson2("Fred", "150") === Left(InvalidAgeRange(150)))
    }
  }

  describe("createPersonAndShow") {

    it("should show a valid Person") {
      assert(createPersonAndShow("Fred", "32") === "Fred is 32")
    }

    it("should show an invalid name") {
      assert(createPersonAndShow("", "32") === "Empty name supplied")
    }

    it("should show an invalid age value") {
      assert(createPersonAndShow("Fred", "ThirtyTwo") === "Invalid age value supplied: ThirtyTwo")
    }

    it("should show an invalid age range") {
      assert(createPersonAndShow("Fred", "150") === "Provided age must be between 1-120: 150")
    }

  }

  describe("makeNameUpperCase") {

    it("should show a valid Person") {
      assert(makeNameUpperCase("Fred", "32") === Right(Person("FRED", 32)))
    }

    it("should show an invalid name") {
      assert(makeNameUpperCase("", "32") === Left(EmptyName))
    }

    it("should show an invalid age value") {
      assert(makeNameUpperCase("Fred", "ThirtyTwo") === Left(InvalidAgeValue("ThirtyTwo")))
    }

    it("should show an invalid age range") {
      assert(makeNameUpperCase("Fred", "150") === Left(InvalidAgeRange(150)))
    }
  }

  describe("createValidPeople") {

    it("should return a List Person instances") {
      assert(createValidPeople === List(Person("Tokyo", 30), Person("Berlin", 43)))
    }
  }

  describe("collectErrors") {

    it("should return a List of errors returned while processing inputs") {
      assert(collectErrors === List(InvalidAgeValue("5o"),
                                    InvalidAgeRange(200),
                                    InvalidAgeRange(0),
                                    EmptyName))
    }
  }
}
