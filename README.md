# Intro to Scala Fundamentals

This is a two day course. You are expected to know how to program in at least one programming language (Java, Ruby, JavaScript, etc.). The course teaches the fundamentals of using Scala as a functional programming language.

This course is meant to be run in person. There are comments in the exercises to try and point you in the right direction so you should be able to do this in your spare time if you desire. Unit tests are included to verify your solutions for each exercise.

Use `sbt test` to run the tests. The first time you run the tests, they will all fail. This is a good thing! As you complete each exercise correctly, the tests will pass.

We welcome pull requests and feedback!

## Schedule

### Day 1

* 9.30 - Start
* 10 - Intro to FP/Scala (__presentation__)
* 10.30 - [IntroExercises](src/main/scala/fundamentals/level01/IntroExercises.scala)
* 11 - 15 min break
* 11.15 - Intro to ADTs (__presentation__)
* 11.45 - [TypesExercises](src/main/scala/fundamentals/level02/TypesExercises.scala)
* 12.45 - Lunch
* 1:45 - [ListExercises](src/main/scala/fundamentals/level02/ListExercises.scala)
* 3 - 30 min break
* 3.30 - [NullExercises](src/main/scala/fundamentals/level03/NullExercises.scala) (skip if familiar with downside of nulls)
* 4 - [OptionExercises pt. 1 (Safe constructors)](src/main/scala/fundamentals/level03/OptionExercises1.scala)
* 5 - End

### Day 2

* 9.30 - Intro to Error Handling (__presentation__)
* 10 - [OptionExercises pt. 2](src/main/scala/fundamentals/level03/OptionExercises2.scala)
* 11 - 15 min break
* 11.15 - [OptionExercises pt. 3](src/main/scala/fundamentals/level03/OptionExercises3.scala)
* 12.00 - [ExceptionExercises](src/main/scala/fundamentals/level03/ExceptionExercises.scala) (skip if familiar with downside of exceptions)
* 12.45 - Lunch
* 1.45 - [Exceptions2EitherExercises](src/main/scala/fundamentals/level03/Exceptions2EitherExercises.scala) / [EitherExercises (Optional)](src/main/scala/fundamentals/level03/EitherExercises.scala)
* 3 - 30 min break
* 3.30 - [TryExercises](src/main/scala/fundamentals/level03/TryExercises.scala)
* 4 - [LogParser](src/main/scala/fundamentals/level04/LogParser.scala)
* 5 - End

## Pre-requisites

**1. Fork or clone this repository**

```
git clone https://github.com/wjlow/intro-to-scala.git
cd intro-to-scala/
```

**2. Install Java 8 (do not install Java 9 or Java 10)**

```
brew tap caskroom/versions
brew cask install java8
```

**3. Install sbt 1.x (recommended but optional, we have included a portable version)**

We recommend that you install `sbt` on your machine even though a portable runner is included.

> The actual version of `sbt` used is in your `project/build.properties` file and the global `sbt` is merely used for bootstrapping your project. You should not get conflicting `sbt` installations even if you have multiple Scala projects using different versions of `sbt`.

```
brew install sbt@1
```

__Tip__: Launching SBT might take some time, so we recommend using SBT's interactive shell to run commands, instead of lauching SBT for each command.

To run the `sbt` shell from the global installation use:

```
sbt
```

To run the `sbt` shell from the portable installation use:

```
./sbt
```

**[4. Compile program to resolve dependencies before the course](#compilation)**

**[5. IDE setup](#ide-setup)**

## Compilation

Launch the SBT shell.

To only compile production code use:

```
~compile
```

To compile production and test code use:

```
~test:compile
```

## How to run tests

### To run all tests

To run all tests use:

```
test
```

The first time you run all the tests you will get a lot of errors! These tests will be fixed by you during the duration of the course.

### Running a single test file

In the meantime, run only a single test case at a time to keep things manageable.

To run a single test use:

```
~testOnly package.path.of.test.TestName
```


For example to run only the _fundamentals.level01.IntroExercisesTest_ test case use:

```
~testOnly fundamentals.level01.IntroExercisesTest
```

To run by test case name only use:

```
~testOnly *TestName
```

For example to run the _fundamentals.level01.IntroExercisesTest_ test case use:

```
~testOnly *IntroExercisesTest
```


The `~` watches for changes to your files and runs the command automatically. It's nice to use it to get really fast feedback as you are working on the exercises!

To stop watching changes through `~`, use the __enter__ key to return to the SBT shell prompt.

## Jumping into a Scala REPL

To launch into a Scala REPL with all production code use:

```
console
```

To launch into a Scala REPL with all production and test code use:

```
test:console
```

Type `:q` to exit from the REPL and return to SBT.

## Exiting SBT

To exit the SBT shell use:

```
exit
```

[SBT 1.x documentation](https://www.scala-sbt.org/1.x/docs/index.html)

## IDE setup

<details><summary>IntelliJ IDEA</summary>

![intellij](intellij.png)

<p>

1. [Download IntelliJ (free Community edition is fine)](https://www.jetbrains.com/idea/download/#section=mac)

2. Install and open IntelliJ

3. If running IntelliJ for the very first time, it might ask you what plugin you want to install. Select _Scala_, otherwise install manually: _Configure -> Plugins -> Browse Repositories -> Scala_

4. Restart IntelliJ to activate the plugin

5. Open IntelliJ and open this project: _Open -> Select directory where project is in_

6. Wait for IntelliJ to download dependencies (this might take a while)

7. Compile project with Command+F9

8. You can run individual tests by right-clicking and then selecting _Run ...ExercisesTest_ ([or just use SBT](#how-to-run-tests))

Tips:

* Use Command+P inside the argument of a function to see what type the argument needs to be.

* Use Control+Shift+P to find out the type of a highlighted expression.

</p></details>

<details><summary>Text Editor (Vim/Sublime/Atom/Emacs)</summary>

![text editor](sublime.png)

<p>

1. Open the current directory in an editor of your choice.

2. Open the SBT shell in a terminal window.

3. Compiling - [See SBT instructions on how to compile code](#compilation).

4. Running Tests - [See SBT instructions on how to run tests](#how-to-run-tests).

5. Looking up Scala API - You can also search through the [Scala APIs](https://www.scala-lang.org/api/current/) to find any necessary methods or use a documentation browser like [Dash](https://kapeli.com/dash).

6. To explore the Scala API or any of the exercises use the Scala REPL [See SBT instructions on how to jump into the REPL](jumping-into-a-scala-repl).

![scala api browser](scala-api.png)

</p></details>
