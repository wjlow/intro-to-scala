package fundamentals

import org.scalatest.Reporter
import org.scalatest.events._
import scala.collection.mutable.ListBuffer
import scala.io.AnsiColor._
import SimpleReporter._

/**
  *  A Simple reporter that hides most of the unnecessary StackTraces displayed by ScalaTest when a test fails.
  *
  * Usage: {{{ testOnly *TestName -- -C fundamentals.SimpleReporter }}}
  */
final case class RecordedEvent(
  ordinal: Ordinal,
  suiteName: String,
  suiteId: String,
  suiteClassName: String,
  testName: String,
  testText: String,
  location: Option[Location],
  payload: Option[Any] = None,
  timeStamp: Long,
  status: TestStatus,
  throwable: Option[Throwable]
)

//ADT for Test Statuses
sealed trait TestStatus
final case object Passed extends TestStatus
final case object Failed extends TestStatus

final class SimpleReporter extends Reporter {

  private val events = new ListBuffer[RecordedEvent]

  override def apply(event: Event): Unit = {
    event match {
      case TestFailed(ordinal, message, suiteName, suiteId, Some(suiteClassName), testName, testText, _,
                        throwable, _, _, location, _, payload, _, timestamp) =>
          events += RecordedEvent(
                      ordinal,
                      suiteName,
                      suiteId,
                      suiteClassName,
                      testName,
                      testText,
                      location,
                      payload,
                      timestamp,
                      Failed,
                      throwable
                    )

            case TestSucceeded (ordinal, suiteName, suiteId, Some(suiteClassName), testName, testText, _,
                                  _, _, location, _, payload, _, timestamp) =>
              events += RecordedEvent(
                          ordinal,
                          suiteName,
                          suiteId,
                          suiteClassName,
                          testName,
                          testText,
                          location,
                          payload,
                          timestamp,
                          Passed,
                          None
                        )

      case r: RunCompleted =>
          events.groupBy(_.suiteClassName).map {
            case (k, values) =>
              val (passed, failed) = values.foldLeft((0, 0)) {
                case (acc, RecordedEvent(_,_,_,_,_,_,_,_,_,Passed,_)) => (acc._1 + 1, acc._2)
                case (acc, RecordedEvent(_,_,_,_,_,_,_,_,_,Failed,_)) => (acc._1, acc._2 + 1)
              }

              println(s"${green}${k}:${reset} ${green}${passed}${reset}|${red}${failed}${reset}|${passed + failed}")

              values.foreach { v =>

                  val status = v.status match {
                    case Passed => s"  - ${green}${v.testName}${reset} [${green}PASSED${reset}]"
                    case Failed => s"  - ${cyan}${v.testName}${reset} [${red}FAILED${reset}]"
                  }

                  println(status)

                  (v.status, v.throwable) match {
                    case (Failed, Some(error)) =>
                      println(s"${messagePadding}${error.getMessage}")
                      val stacktrace = getStackTrace(error).take(1)
                      if (stacktrace.nonEmpty)
                        println(s"${strackTracePadding}${getStackTrace(error).take(1).mkString("\n${strackTracePadding}")}")
                      else {}

                    case (_, _) =>
                  }
              }
          }

      case _ =>
    }
  }

    private def getStackTrace(throwable: Throwable): Seq[String] = {
      import scala.collection.JavaConverters._
      import java.util.Arrays
      val stacktrace: Seq[StackTraceElement] = Arrays.asList(throwable.getStackTrace:_*).asScala

      stacktrace.
        filterNot(st => shouldFilterOut(st.getClassName, st.getMethodName)).
        map(showStackTraceElement)
    }
}

object SimpleReporter {
  private[SimpleReporter] val FilterOut = Seq("scala.", "org.scalatest", "$anonfun", "sbt.", "java.")

  private[SimpleReporter] def shouldFilterOut(className: String, methodName: String): Boolean =
    FilterOut.exists(fo => className.contains(fo) || methodName.contains(fo))

  import scala.io.AnsiColor._
  private[SimpleReporter] val green   = GREEN
  private[SimpleReporter] val red     = RED
  private[SimpleReporter] val cyan    = CYAN
  private[SimpleReporter] val reset   = RESET

  private[SimpleReporter] val messagePadding = "    > "
  private[SimpleReporter] val strackTracePadding = "      | "

  private[SimpleReporter] def showStackTraceElement(ste: StackTraceElement): String =
    s"${ste.getClassName}.${ste.getMethodName}(${ste.getFileName}:${ste.getLineNumber.toString})"
}