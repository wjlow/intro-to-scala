package introcourse.level04

import introcourse.level04.NullExercises._
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.funspec.AnyFunSpec

class NullExercisesTest extends AnyFunSpec with TypeCheckedTripleEquals {

  describe("mkTrafficLightOrNull") {

    it("should return null given unknown String") {
      assert(mkTrafficLightOrNull("invalid") === null)
    }

    it("should return Red") {
      assert(mkTrafficLightOrNull("red") === Red)
    }

    it("should return Yellow") {
      assert(mkTrafficLightOrNull("yellow") === Yellow)
    }

    it("should return Green") {
      assert(mkTrafficLightOrNull("green") === Green)
    }

  }

  describe("mkTrafficLightOrNullThenShow") {

    it("should show Red traffic light") {
      assert(mkTrafficLightOrNullThenShow("red") === "Traffic light is red")
    }

    it("should show Yellow traffic light") {
      assert(mkTrafficLightOrNullThenShow("yellow") === "Traffic light is yellow")
    }

    it("should show Green traffic light") {
      assert(mkTrafficLightOrNullThenShow("green") === "Traffic light is green")
    }

    it("should show invalid traffic light") {
      assert(mkTrafficLightOrNullThenShow("bob") === "Traffic light is invalid")
    }

  }

  describe("mkPersonOrNull") {

    it("should return Person") {
      assert(mkPersonOrNull("Bob", 20) === Person("Bob", 20))
    }

    it("should return null if name is blank") {
      assert(mkPersonOrNull("", 20) === null)
    }

    it("should return null if age < 0") {
      assert(mkPersonOrNull("Bob", -1) === null)
    }

  }

  describe("mkPersonOrNullThenChangeName") {

    it("should return Person with name set to newName") {
      assert(mkPersonOrNullThenChangeName("Old Name", 20, "New Name") === Person("New Name", 20))
    }

    it("should return null if oldName is blank") {
      assert(mkPersonOrNullThenChangeName("", 20, "New Name") === null)
    }

    it("should return null if newName is blank") {
      assert(mkPersonOrNullThenChangeName("Bob", 20, "") === null)
    }

    it("should return null if age < 0") {
      assert(mkPersonOrNullThenChangeName("Old Name", -1, "New Name") === null)
    }

  }

}
