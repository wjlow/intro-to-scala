package fundamentals.level03

import fundamentals.level03.OptionExercises2.Job
import fundamentals.level03.OptionExercises3._
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec

class OptionExercises3Test extends FunSpec with TypeCheckedTripleEquals {

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
      assert(findJobByHumanIdUsingFor(2) === Some(Job("Teacher", "Expert in their field"))) // Timmy
    }

  }

}
