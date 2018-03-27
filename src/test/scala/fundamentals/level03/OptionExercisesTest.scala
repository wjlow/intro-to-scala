package fundamentals.level03

import fundamentals.level02.TypesExercises.{Green, Person, Red, Yellow}
import fundamentals.level03.OptionExercises._
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec

class OptionExercisesTest extends FunSpec with TypeCheckedTripleEquals {

  describe("safeMean") {

    it("should return None given Nil") {
      assert(safeMean(Nil) === None)
    }

    it("should return the mean of a non-empty List of numnbers") {
      assert(safeMean(List(1, 2, 3)) === Some(2.0))
    }

  }

  describe("mkTrafficLight") {

    it("should return None given unknown String") {
      assert(mkTrafficLight("invalid") === None)
    }

    it("should return Red") {
      assert(mkTrafficLight("red") === Some(Red))
    }

    it("should return Yellow") {
      assert(mkTrafficLight("yellow") === Some(Yellow))
    }

    it("should return Green") {
      assert(mkTrafficLight("green") === Some(Green))
    }

  }

  describe("mkTrafficLightThenShow") {

    it("should show Red traffic light") {
      assert(mkTrafficLightThenShow("red") === "Traffic light is red")
    }

    it("should show invalid traffic light") {
      assert(mkTrafficLightThenShow("bob") === "Traffic light `bob` is invalid")
    }

  }

  describe("mkPerson") {

    it("should return Person") {
      assert(mkPerson("Bob", 20) === Some(Person("Bob", 20)))
    }

    it("should return None if name is blank") {
      assert(mkPerson("", 20) === None)
    }

    it("should return None if age < 0") {
      assert(mkPerson("Bob", -1) === None)
    }

  }

  describe("mkPersonThenChangeName") {

    it("should return Person with name set to newName") {
      assert(mkPersonThenChangeName("Old Name", 20, "New Name") === Some(Person("New Name", 20)))
    }

    it("should return None if oldName is blank") {
      assert(mkPersonThenChangeName("", 20, "New Name") === None)
    }

    it("should return None if age < 0") {
      assert(mkPersonThenChangeName("Old Name", -1, "New Name") === None)
    }

  }

}
