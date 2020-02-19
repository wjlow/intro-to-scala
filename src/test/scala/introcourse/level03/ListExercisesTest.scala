package introcourse.level03

import introcourse.level03.ListExercises._
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.funspec.AnyFunSpec

class ListExercisesTest extends AnyFunSpec with TypeCheckedTripleEquals {

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

    it("should return the first person in the list with the smallest age given a non-empty List") {
      val youngest = Person("Karen Page", 27)

      assert(youngestPerson(peopleList) === youngest)
    }

  }

  describe("personWithIndex") {

    it("should return each person with their 1-based index") {
      assert(personWithIndex(peopleList) === (
        List((Person("Matt Murdock",            30), 1),
             (Person("Karen Page",              27), 2),
             (Person("Franklin 'Foggy' Nelson", 31), 3),
             (Person("Claire Temple",           32), 4),
             (Person("Wilson Fisk",             42), 5),
             (Person("Elektra Natchios",        27), 6)))
      )
    }
  }

  describe("showEveryNthPerson") {

    it("should show every Nth person") {
      val people = ListExercises.peopleList
      val all = people.map(showPerson)

      assert(showEveryNthPerson(-5, people) === all)
      assert(showEveryNthPerson(0, people)  === all)
      assert(showEveryNthPerson(1, people)  === all)
      assert(showEveryNthPerson(2, people)  === List("Karen Page is 27 years old", "Claire Temple is 32 years old", "Elektra Natchios is 27 years old"))
      assert(showEveryNthPerson(3, people)  === List("Franklin 'Foggy' Nelson is 31 years old", "Elektra Natchios is 27 years old"))
      assert(showEveryNthPerson(5, people)  === List("Wilson Fisk is 42 years old"))
      assert(showEveryNthPerson(6, people)  === List("Elektra Natchios is 27 years old"))
      assert(showEveryNthPerson(8, people)  === Nil)
    }
  }

  describe("getNames") {

    it("should return the names of all persons") {
      val powerRangers = List(Person("Red Ranger", 22), Person("Yellow Ranger", 20), Person("Pink Ranger", 21))
      val names = getNames(powerRangers)
      assert(names === List("Red Ranger", "Yellow Ranger", "Pink Ranger"))
    }

  }

  describe("getAdults") {

    it("should return persons aged >= 18") {
      val powerRangers = List(Person("Red Ranger", 17), Person("Yellow Ranger", 18), Person("Pink Ranger", 19))
      val adults = getAdults(powerRangers)
      assert(adults === List(Person("Yellow Ranger", 18), Person("Pink Ranger", 19)))
    }

  }

  describe("reverseList") {

    it("should return the input list reversed") {
      val inputList = List(1, 2, 3)
      val result = reverseList(inputList)
      assert(result === List(3, 2, 1))
    }

  }

  describe("sublists") {

    it("should pack consecutive duplicates of list elements into sublists") {
      val inputList = List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")
      val result = sublists(inputList)
      assert(result === List(List("a", "a", "a", "a"), List("b"), List("c", "c"), List("a", "a"), List("d"), List("e", "e", "e", "e")))
    }

  }

}
