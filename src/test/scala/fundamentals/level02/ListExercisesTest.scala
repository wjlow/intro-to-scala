package fundamentals.level02

import fundamentals.level02.ListExercises._
import fundamentals.level02.TypesExercises.Person
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec

class ListExercisesTest extends FunSpec with TypeCheckedTripleEquals {

  describe("prependToList") {

    it("should add an element to the start of the List") {
      val list = prependToList(1, List(2, 3, 4))
      assert(list === List(1, 2, 3, 4))
    }

  }

  describe("appendToList") {

    it("should add an element to the end of the List") {
      val list = appendToList(1, List(2, 3, 4))
      assert(list === List(2, 3, 4, 1))
    }

  }

  describe("isEmptyList") {

    it("should return True for Nil") {
      assert(isEmptyList(Nil) === true)
    }

    it("should return False for non-empty List") {
      assert(isEmptyList(1 :: 2 :: Nil) === false)
    }

  }

  describe("showListSize") {

    it("should show size for Nil") {
      assert(showListSize(Nil) === "This is an empty list")
    }

    it("should show size for non-empty List") {
      assert(showListSize(1 :: 2 :: 3 :: Nil) === "This is a list of size 3")
    }

  }

  describe("addNumToEach") {

    it("should return Nil given Nil") {
      assert(addNumToEach(5, Nil) === Nil)
    }

    it("should add 5 to each element of non-empty List") {
      assert(addNumToEach(5, List(1, 2, 3)) === List(6, 7, 8))
    }

  }

  describe("filterEven") {

    it("should return even numbers") {
      assert(filterEven(List(1, 2, 3, 4, 5, 6)) == List(2, 4, 6))
    }

  }

  describe("product") {

    it("should return 1 given Nil") {
      assert(product(Nil) === 1)
    }

    it("should multiply all the elements of non-empty List") {
      assert(product(List(2, 5, 3)) === 30)
    }
  }

  describe("min") {

    it("should return smallest Int given Nil") {
      assert(min(Nil) === Int.MinValue)
    }

    it("should return smallest number in non-empty List") {
      assert(min(List(4, 6, 1)) === 1)
    }

  }

  describe("youngestPerson") {

    it("should return a silly default person given Nil") {
      assert(youngestPerson(Nil) === Person("Nobody", 0))
    }

    it("should return person with the smallest age given non-empty List") {
      val bob = Person("Bob", 22)
      val sally = Person("Sally", 21)
      val jimmy = Person("Jimmy", 21)
      val persons = List(bob, sally, jimmy)

      assert(youngestPerson(persons) === sally)
    }

  }

}
