name := "intro-to-scala"

version := "0.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % Test

scalaVersion := "2.13.1"

scalacOptions ++= Seq(
  "-Werror"
)
