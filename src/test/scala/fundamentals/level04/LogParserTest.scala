package fundamentals.level04

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec
import LogParser._

class LogParserTest extends FunSpec with TypeCheckedTripleEquals {

  describe("parseLog") {

    it("should return a KnownLog") {
      val knownLog = parseLog("I,147,mice in the air")
      assert(knownLog === ???)
    }
    
    it("should return an UnknownLog") {
      val unknownLog = parseLog("X blblbaaaaa")
      assert(unknownLog === ???)
    }

  }
  
  describe("parseLogFile") {
    
    it("should return a List of LogMessage") {
      val logMessages = parseLogFile("I,147,mice in the air\nX blblbaaaaa")
      assert(logMessages === List(???, ???))
    }
    
    it("should return an empty List") {
      val logMessages = parseLogFile("")
      assert(logMessages === Nil)
    }
    
  }
  
  describe("getUnknowns") {
    
    it("should return the unknowns only") {
      val known = parseLog("I,147,mice in the air")
      val unknown1 = parseLog("X blblbaaaaa")
      val unknown2 = parseLog("W foo")

      val unknownsOnly = getUnknowns(List(known, unknown1, unknown2))

      assert(unknownsOnly === List(unknown1, unknown2))
    }
    
  }

  describe("findLatestError") {

    it("should return error with highest timestamp") {
      val log1 = parseLog("E,1,100,one")
      val log2 = parseLog("E,1,200,two")
      val log3 = parseLog("E,1,300,three")

      val latestError = findLatestError(List(log1, log2, log3))

      assert(latestError === Some(log3))
    }

    it("should return None if no errors found") {
      val log1 = parseLog("I,100,one")
      val log2 = parseLog("I,200,two")
      val log3 = parseLog("I,300,three")

      val latestError = findLatestError(List(log1, log2, log3))

      assert(latestError === None)
    }

  }

  describe("showLogMessage") {

    it("should return Info LogMessage in readable format") {
      val info = parseLog("I,100,one")

      assert(showLogMessage(info) === "Info (100) one")
    }

    it("should return Warning LogMessage in readable format") {
      val warn = parseLog("W,100,caution!")

      assert(showLogMessage(warn) === "Warning (100) caution!")
    }

    it("should return Error LogMessage in readable format") {
      val error = parseLog("E,1,300,some message")

      assert(showLogMessage(error) === "Error 1 (300) some message")
    }

  }

  describe("showErrorsOverSeverity") {

    it("should all errors over a given severity level in a readable format") {
      val logFile =
        """|I,147,mice in the air
           |W,149,could've been bad
           |E,5,158,some strange error
           |E,6,170,another error
           |E,2,148,istereadea""".stripMargin

      val errorsOverLevel4 = showErrorsOverSeverity(logFile, 4)

      assert(errorsOverLevel4 === List("Error 5 (158) some strange error", "Error 6 (170) another error"))
    }

  }

}
