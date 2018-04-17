# intro-to-scala

Two day Scala fundamentals course.

This course is meant to be run in person. There are comments in the exercises to try and point you to the right direction so you should be able to do this in your spare time if you desire. Unit tests are included to verify your solutions for each exercise. 

Use `./sbt test` to run the tests. The first time you run the tests, they will all fail. This is a good thing! As you complete each exercise correctly, the tests will pass.

We welcome pull requests and feedback!

## Schedule

### Day 1

* 9.30 - Start
* 10 - Intro to FP/Scala
* 10.30 - [IntroExercises](src/main/scala/fundamentals/level01/IntroExercises.scala)
* 11 - Break
* 11.15 - Intro to ADTs
* 11.30 - [TypesExercises](src/main/scala/fundamentals/level02/TypesExercises.scala)
* 12.15 - Lunch
* 1:30 - [ListExercises](src/main/scala/fundamentals/level02/ListExercises.scala)
* 3 - Break
* 3.15 - [NullExercises](src/main/scala/fundamentals/level03/NullExercises.scala) (skip if familiar with downside of nulls)
* 3.45 - [OptionExercises pt. 1 (Safe constructors)](src/main/scala/fundamentals/level03/OptionExercises1.scala)
* 4:45 - End

### Day 2

* 9.30 - Intro to Error Handling
* 10.15 - [OptionExercises pt. 2](src/main/scala/fundamentals/level03/OptionExercises2.scala)
* 11.15 - Break
* 11.30 - [ExceptionExercises](src/main/scala/fundamentals/level03/ExceptionExercises.scala) (skip if familiar with downside of exceptions)
* 12.30 - Lunch
* 1.30 - [Exceptions2EitherExercises](src/main/scala/fundamentals/level03/Exceptions2EitherExercises.scala) / [EitherExercises (Optional)](src/main/scala/fundamentals/level03/EitherExercises.scala)
* 2 - Break
* 2.15 - [TryExercises](src/main/scala/fundamentals/level03/TryExercises.scala)
* 3.15 - [LogParser](src/main/scala/fundamentals/level04/LogParser.scala)
* 4.15 - End

## Pre-requisites

**Install Java 8**

```
brew tap caskroom/versions
brew cask install java8
```

**Install sbt (recommended but optional, we have included a portable version)**

We recommend that you install `sbt` on your machine even though a portable runner is included. The actual version of `sbt` used is in your `project/build.properties` file and the global `sbt` is merely used for bootstrapping your project. You should not get conflicting `sbt` installations even if you have multiple Scala projects using different versions of `sbt`.

```
brew install sbt
```

To run `sbt` installed globally:

```
sbt
```

To run portable `sbt`:

```
./sbt
```

**Compile program to resolve dependencies**

```
./sbt compile
```

## How to run tests

### To run all tests

```
./sbt test
```

### Running a single test file

```
./sbt '~testOnly fundamentals.level01.IntroExercisesTest'
```

or 

```
./sbt '~testOnly *IntroExercisesTest'
```


The `~` watches for changes to your files and runs the command automatically. It's nice to use it to get really fast feedback as you are working on the exercises!
