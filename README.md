# intro-to-scala

Two day Scala fundamentals course.

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

Install Java

```
brew cask install java
```

Install sbt

```
brew install sbt
```

Compile program to resolve dependencies

```
sbt compile
```

## How to run tests

```
sbt test
```
