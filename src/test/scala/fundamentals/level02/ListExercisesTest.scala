package fundamentals.level02

import fundamentals.level02.ListExercises._
import org.scalatest.FunSpec

class ListExercisesTest extends FunSpec {

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

  // TODO: Write unit tests for `isEmptyList`

  // TODO: Write unit tests for `showListSize`

  // TODO: Write unit test for `addNumToEach`

  // TODO: Write unit test for `filterEven`

  // TODO: Write unit test for `product`

  // TODO: Write unit test for `min`

  // TODO: Write unit test for `youngestPerson`

  // TODO: Write unit test for `showEveryTenthPerson`

}
