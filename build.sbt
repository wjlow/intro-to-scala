name := "intro-to-scala"

version := "0.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test

scalaVersion := "2.13.0"

scalacOptions ++= Seq(
  "-Werror",
  "-deprecation"
)
