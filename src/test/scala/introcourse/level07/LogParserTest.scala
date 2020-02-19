package introcourse.level07

import introcourse.level07.LogParser._
import introcourse.level07.Types._
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.funspec.AnyFunSpec

class LogParserTest extends AnyFunSpec with TypeCheckedTripleEquals {

  describe("parseIntOption") {
    it("should return the parsed integer for a valid integer") {
      val parsed = parseIntOption("123")
      assert(parsed === Some(123))
    }

    it("should return a None for an invalid integer") {
      val parsed = parseIntOption("12a")
      assert(parsed === None)
    }
  }

  describe("parseLog") {

    it("should return a KnownLog for an Info") {
      val knownLog = parseLog("I,147,mice in the air")
      assert(knownLog === KnownLog(Info, 147, "mice in the air"))
    }

    it("should return a KnownLog for a Warning") {
      val knownLog = parseLog("W,188,hamsters underground")
      assert(knownLog === KnownLog(Warning, 188, "hamsters underground"))
    }

    it("should return a KnownLog for an Error") {
      val knownLog = parseLog("E,5,193,ferrets out at sea")
      assert(knownLog === KnownLog(Error(5), 193, "ferrets out at sea"))
    }

    it("should return an UnknownLog") {
      val unknownLog = parseLog("X blblbaaaaa")
      assert(unknownLog === UnknownLog("X blblbaaaaa"))
    }

  }

  describe("parseLogFile") {

    it("should return a List of LogMessage") {
      val logMessages = parseLogFile("I,147,mice in the air\nX blblbaaaaa")
      assert(logMessages ===
        List(KnownLog(Info, 147, "mice in the air"), UnknownLog("X blblbaaaaa")))
    }

    it("should return an empty List") {
      val logMessages = parseLogFile("")
      assert(logMessages === Nil)
    }

  }

  describe("getErrorsOverSeverity") {

    it("should return the errors over severity level only") {
      val errorLogUnderSeverity = KnownLog(Error(2), 123, "some error msg")
      val errorLogOverSeverity = KnownLog(Error(3), 123, "some error msg")
      val unknown1 = UnknownLog("X blblbaaaaa")
      val unknown2 = UnknownLog("W foo")

      val errorsOnly = getErrorsOverSeverity(List(errorLogUnderSeverity, errorLogOverSeverity, unknown1, unknown2), 2)

      assert(errorsOnly === List(errorLogOverSeverity))
    }

  }

  describe("showLogMessage") {

    it("should return Info LogMessage in readable format") {
      val info = KnownLog(Info, 100, "one")

      assert(showLogMessage(info) === "Info (100) one")
    }

    it("should return Warning LogMessage in readable format") {
      val warn = KnownLog(Warning, 100, "caution!")

      assert(showLogMessage(warn) === "Warning (100) caution!")
    }

    it("should return Error LogMessage in readable format") {
      val error = KnownLog(Error(1), 300, "some message")

      assert(showLogMessage(error) === "Error 1 (300) some message")
    }

    it("should return UnknownLog in readable format") {
      val error = UnknownLog("message")

      assert(showLogMessage(error) === "Unknown log: message")
    }

  }

  describe("showErrorsOverSeverity") {

    it("should show all errors over a given severity level in a readable format") {
      val logFile =
        """|I,147,mice in the air
           |W,149,could've been bad
           |E,5,158,some strange error
           |E,6,170,another error
           |E,2,148,istereadea
           |E,4,199,frabjous""".stripMargin

      val errorsOverLevel4 = showErrorsOverSeverity(logFile, 4)

      assert(errorsOverLevel4 === List("Error 5 (158) some strange error", "Error 6 (170) another error"))
    }

  }

}
