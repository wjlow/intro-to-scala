package introcourse.level04

import introcourse.level04.OptionExercises2._
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.funspec.AnyFunSpec

class OptionExercises2Test extends AnyFunSpec with TypeCheckedTripleEquals {

  describe("findHumanById") {

    it("should return None if humanId is not in humansDatabase") {
      assert(findHumanById(1024) === None)
    }

    it("should return Human with humanId") {
      assert(findHumanById(1) === Some(Human("Sally", None)))
      assert(findHumanById(2) === Some(Human("Jenny", Some(1))))
    }

  }

  describe("findJobById") {

    it("should return None if jobId is not in jobsDatabase") {
      assert(findJobById(1024) === None)
    }

    it("should return Job with jobId") {
      assert(findJobById(1) === Some(Job("Teacher", "Expert in their field")))
      assert(findJobById(2) === Some(Job("Engineer", "Build things for people")))
    }

  }

  describe("findJobDescriptionGivenJobId1") {

    it("should return None if jobId is not in jobsDatabase") {
      assert(findJobDescriptionGivenJobId1(1024) === None)
    }

    it("should return description for Job with jobId") {
      assert(findJobDescriptionGivenJobId1(1) === Some("Expert in their field"))
      assert(findJobDescriptionGivenJobId1(2) === Some("Build things for people"))
    }

  }

  describe("findJobDescriptionGivenJobId2") {

    it("should return None if jobId is not in jobsDatabase") {
      assert(findJobDescriptionGivenJobId2(1024) === None)
    }

    it("should return description for Job with jobId") {
      assert(findJobDescriptionGivenJobId2(1) === Some("Expert in their field"))
      assert(findJobDescriptionGivenJobId2(2) === Some("Build things for people"))
    }

  }

  describe("findJobDescriptionGivenJobIdOrElse1") {

    it("should return `does not exist` message if jobId is not in jobsDatabase") {
      assert(findJobDescriptionGivenJobIdOrElse1(1024) === "Job with id 1024 does not exist")
    }

    it("should return description for Job with jobId") {
      assert(findJobDescriptionGivenJobIdOrElse1(1) === "Expert in their field")
      assert(findJobDescriptionGivenJobIdOrElse1(2) === "Build things for people")
    }

  }

  describe("findJobDescriptionGivenJobIdOrElse2") {

    it("should return `does not exist` message if jobId is not in jobsDatabase") {
      assert(findJobDescriptionGivenJobIdOrElse2(1024) === "Job with id 1024 does not exist")
    }

    it("should return description for Job with jobId") {
      assert(findJobDescriptionGivenJobIdOrElse2(1) === "Expert in their field")
      assert(findJobDescriptionGivenJobIdOrElse2(2) === "Build things for people")
    }

  }

  describe("findJobIdByHumanId") {

    it("should return None if humanId is not in humansDatabase") {
      assert(findJobIdByHumanId(1024) === None)
    }

    it("should return None if humanId is found but Human has no job") {
      assert(findJobIdByHumanId(1) === None) // Sally
    }

    it("should return jobId if humanId is found and Human has a job") {
      assert(findJobIdByHumanId(2) === Some(1)) // Jenny
    }

  }

  describe("findJobByHumanId") {

    it("should return None if humanId is not in humansDatabase") {
      assert(findJobByHumanId(1024) === None)
    }

    it("should return None if humanId is found but Human has no job") {
      assert(findJobByHumanId(1) === None) // Sally
    }

    it("should return None if humanId is found and Human has a job that is not in jobsDatabase") {
      assert(findJobByHumanId(3) === None) // Timmy
    }

    it("should return jobId if humanId is found and Human has a job that is in jobsDatabase") {
      assert(findJobByHumanId(2) === Some(Job("Teacher", "Expert in their field"))) // Jenny
    }

  }

  describe("findJobNameByHumanId") {

    it("should return None because Sally does not have a job") {
      assert(findJobNameByHumanId(1) === None)
    }

    it("should return Teacher because Jenny is a teacher") {
      assert(findJobNameByHumanId(2) === Some("Teacher"))
    }

    it("should return None because Timmy's job does not exist") {
      assert(findJobNameByHumanId(3) === None)
    }

  }

}
