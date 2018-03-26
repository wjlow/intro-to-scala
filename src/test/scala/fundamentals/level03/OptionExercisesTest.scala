package fundamentals.level03

import fundamentals.level02.TypesExercises.{Green, Red, Yellow}
import fundamentals.level03.OptionExercises._
import org.scalatest.FunSpec

class OptionExercisesTest extends FunSpec {

  describe("safeMean") {

    it("should return None given Nil") {
      assert(safeMean(Nil) === None)
    }

    it("should return the mean of a non-empty List of numnbers") {
      assert(safeMean(List(1, 2, 3)) === 2)
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

}
