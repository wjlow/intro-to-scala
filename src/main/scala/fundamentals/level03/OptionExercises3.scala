package fundamentals.level03

import fundamentals.level03.OptionExercises2.{HumanId, Job, JobId, findHumanById, findJobById}

/**
  * These exercises mirror the ones from `OptionExercises2.scala`,
  * they are for the purpose of teaching for-comprehension
  */
object OptionExercises3 {

  /**
    * scala> findJobIdByHumanIdUsingFor(1)
    * = None
    *
    * scala> findJobIdByHumanIdUsingFor(2)
    * = Some(1)
    */
  def findJobIdByHumanIdUsingFor(humanId: HumanId): Option[JobId] = ???
//    for {
//      human <- ??? // Find a function of type HumanId => Option[Human]
//      jobId <- ??? // Find a function of type Human => Option[JobId]
//    } yield jobId

  /**
    * scala> findJobByHumanIdUsingFor(2)
    * = Some(Job("Teacher", "Expert in their field"))
    *
    * Hint: Use findJobIdByHumanIdUsingFor
    */
  def findJobByHumanIdUsingFor(humanId: HumanId): Option[Job] = ???
//    for {
//      jobId <- ??? // Find a function of type HumanId => Option[JobId]
//      job <- ???   // Find a function of type JobId => Option[Job]
//    } yield job

}
