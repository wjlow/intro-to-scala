package fundamentals.level04

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec
import LogParser._
import Types._

class LogParserTest extends FunSpec with TypeCheckedTripleEquals {

  describe("parseLog") {

    it("should return a KnownLog") {
      val knownLog = parseLog("I,147,mice in the air")
      assert(knownLog === KnownLog(Info, 147, "mice in the air"))
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

  describe("getUnknowns") {

    it("should return the unknowns only") {
      val known = KnownLog(Info, 147, "mice in the air")
      val unknown1 = UnknownLog("X blblbaaaaa")
      val unknown2 = UnknownLog("W foo")

      val unknownsOnly = getUnknowns(List(known, unknown1, unknown2))

      assert(unknownsOnly === List(unknown1, unknown2))
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
