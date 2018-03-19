package fundamentals.level04

import scala.io.Source

object Main {

  def main(args: Array[String]): Unit = {

    args match {
      case Array(filepath) =>

        // Read from file
        val fileContent: String = Source.fromFile(filepath).getLines().mkString("\n")

        // Call `printErrorsOverSeverity`
        ???

      case _ => println("""sbt "runMain fundamentals.level04.Main src/main/resources/logfile.csv"""")
    }

  }

  /**
    * Note that at no point have we printed anything out to the user.
    * By pushing side-effects like printing to stdout to the very end of our program,
    * we are able to unit test the majority of our program.
    *
    * Now, using `showErrorsOverSeverity`, let's print out the results to stdout.
    */
  private def printErrorsOverSeverity(logFile: String, severity: Int): Unit = ???

}
