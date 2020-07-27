name := "intro-to-scala"

version := "0.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0" % Test

scalaVersion := "2.13.3"

scalacOptions ++= Seq(
  "-Werror"
)
