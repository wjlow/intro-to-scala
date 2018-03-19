package fundamentals.level04

import scala.io.Source

object Main {

  def main(args: Array[String]): Unit = {

    args match {
      case Array(filepath) =>

        // Read from file
        val fileContent = Source.fromFile(filepath).getLines().mkString("\n")

        // Call `LogParser.printErrorsOverSeverity`
        ???

      case _ => println("""sbt "runMain fundamentals.level04.Main src/main/resources/logfile.csv"""")
    }

  }

}
