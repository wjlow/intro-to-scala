package introcourse.level07

import scala.io.Source
import LogParser._

/**
  * The `main` method does the following:
  *
  * 1. Read `filepath` from CLI args
  * 2. Read the content in `filepath`
  * 3. Call `showErrorsOverSeverity` from `LogParser.scala`
  * 4. Print the errors out to STDOUT
  */
object Main {

  def main(args: Array[String]): Unit = {

    args match {
      case Array(filepath) =>

        // Read from file
        val fileContent: String = Source.fromFile(filepath).getLines().mkString("\n")

        // Implement `printErrorsOverSeverity` and then call it from here
        ???

      case _ => println("""sbt "runMain introcourse.level07.Main src/main/resources/logfile.csv"""")
    }

  }

  /**
    * Note that at no point have we printed anything out to the user.
    * By pushing side-effects like printing to stdout to the very end of our program,
    * we are able to unit test the majority of our program.
    *
    * Now, using `showErrorsOverSeverity`, let's print out the results to stdout.
    *
    * Hint: Use println to write to stdout
    */
  @SuppressWarnings(Array("org.wartremover.warts.Any"))
  private def printErrorsOverSeverity(logFile: String, severity: Int): Unit = ???

}
