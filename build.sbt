name := "intro-to-scala"

version := "0.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % Test

scalaVersion := "2.13.8"

scalacOptions ++= Seq(
  "-Werror"
)
