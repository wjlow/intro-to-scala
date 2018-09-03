package fundamentals.level03

import fundamentals.level03.OptionExercises2.{HumanId, Job, JobId, findHumanById, findJobById}

/**
  * These exercises mirror the ones from `OptionExercises2.scala`,
  * they are for the purpose of teaching for-comprehension, which is very useful for working with `Option`.
  */
object OptionExercises3 {

  /**
    * scala> findJobIdByHumanIdUsingFor(1)
    * = None
    *
    * scala> findJobIdByHumanIdUsingFor(2)
    * = Some(1)
    */
  def findJobIdByHumanIdUsingFor(humanId: HumanId): Option[JobId] =
    for {
      human <- findHumanById(humanId)
      jobId <- human.optJobId
    } yield jobId

  /**
    * scala> findJobByHumanIdUsingFor(2)
    * = Some(Job("Teacher", "Expert in their field"))
    *
    * Hint: Use findJobIdByHumanIdUsingFor
    */
  def findJobByHumanIdUsingFor(humanId: HumanId): Option[Job] =
    for {
      jobId <- findJobIdByHumanIdUsingFor(humanId)
      job <- findJobById(jobId)
    } yield job

  /**
    * scala> findJobDescriptionByHumanIdUsingFor(2)
    * = Some("Teacher")
    *
    * scala> findJobDescriptionByHumanIdUsingFor(1)
    * = None
    *
    * Hint: Use `findJobByHumanIdUsingFor` and for comprehension
    */
  def findJobNameByHumanIdUsingFor(humanId: HumanId): Option[String] =
    for {
      job <- findJobByHumanIdUsingFor(humanId)
    } yield job.name
}
