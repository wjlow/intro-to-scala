package introcourse.level04

import introcourse.level04.OptionExercises2.Job
import introcourse.level04.OptionExercises3._
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.funspec.AnyFunSpec

class OptionExercises3Test extends AnyFunSpec with TypeCheckedTripleEquals {

  describe("findJobIdByHumanIdUsingFor") {

    it("should return None if humanId is not in humansDatabase") {
      assert(findJobIdByHumanIdUsingFor(1024) === None)
    }

    it("should return None if humanId is found but Human has no job") {
      assert(findJobIdByHumanIdUsingFor(1) === None) // Sally
    }

    it("should return jobId if humanId is found and Human has a job") {
      assert(findJobIdByHumanIdUsingFor(2) === Some(1)) // Jenny
    }

  }

  describe("findJobByHumanIdUsingFor") {

    it("should return None if humanId is not in humansDatabase") {
      assert(findJobByHumanIdUsingFor(1024) === None)
    }

    it("should return None if humanId is found but Human has no job") {
      assert(findJobByHumanIdUsingFor(1) === None) // Sally
    }

    it("should return None if humanId is found and Human has a job that is not in jobsDatabase") {
      assert(findJobByHumanIdUsingFor(3) === None) // Timmy
    }

    it("should return jobId if humanId is found and Human has a job that is in jobsDatabase") {
      assert(findJobByHumanIdUsingFor(2) === Some(Job("Teacher", "Expert in their field"))) // Jenny
    }

  }


  describe("findJobNameByHumanIdUsingFor") {

    it("should return None because Sally does not have a job") {
      assert(findJobNameByHumanIdUsingFor(1) === None)
    }

    it("should return Teacher because Jenny is a teacher") {
      assert(findJobNameByHumanIdUsingFor(2) === Some("Teacher"))
    }

    it("should return None because Timmy's job does not exist") {
      assert(findJobNameByHumanIdUsingFor(3) === None)
    }

  }

}
