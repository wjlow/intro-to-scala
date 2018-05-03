# Intro to Scala Fundamentals

This is a two day course. You are expected to know how to program in at least one programming language (Java, Ruby, JavaScript, etc.). The course teaches the fundamentals of using Scala as a functional programming language.

This course is meant to be run in person. There are comments in the exercises to try and point you in the right direction so you should be able to do this in your spare time if you desire. Unit tests are included to verify your solutions for each exercise.

Use `sbt test` to run the tests. The first time you run the tests, they will all fail. This is a good thing! As you complete each exercise correctly, the tests will pass.

We welcome pull requests and feedback!

## Schedule

### Day 1

| Time | Topic/Exercise | Presenter |
| :---: | :---: | :---: |
| 09.30 | Start | |
| 10.00 | Intro to FP/Scala (__presentation__) | C |
| 10.30 | [IntroExercises](src/main/scala/fundamentals/level01/IntroExercises.scala) | F |
| 11.00 | 15 min break | |
| 11.15 | Intro to ADTs (__presentation__) | J |
| 11.45 | [TypesExercises](src/main/scala/fundamentals/level02/TypesExercises.scala) | F |
| 12.45 | Lunch (not provided) | |
| 13.45 | [ListExercises](src/main/scala/fundamentals/level02/ListExercises.scala) | A |
| 15.00 | 30 min break | |
| 15.30 | [NullExercises](src/main/scala/fundamentals/level03/NullExercises.scala) | T |
| 16.00 | [OptionExercises pt. 1 (Safe constructors)](src/main/scala/fundamentals/level03/OptionExercises1.scala) | T |
| 17.00 | End | |

### Day 2

| Time | Topic/Exercise | Presenter |
| :---: | :---: | :---: |
| 09.30 | Intro to Error Handling (__presentation__) | C |
| 10.00 | [OptionExercises pt. 2](src/main/scala/fundamentals/level03/OptionExercises2.scala) | J |
| 11.00 | 15 min break | |
| 11.15 | [OptionExercises pt. 3](src/main/scala/fundamentals/level03/OptionExercises3.scala) | J |
| 12.00 | [ExceptionExercises](src/main/scala/fundamentals/level03/ExceptionExercises.scala) | Sa |
| 12.45 | Lunch (not provided) | |
| 13.45 | [Exceptions2EitherExercises](src/main/scala/fundamentals/level03/Exceptions2EitherExercises.scala) | Sa |
| 15.00 | 30 min break | | 
| 15.30 | [TryExercises](src/main/scala/fundamentals/level03/TryExercises.scala) | A |
| 16.00 | [LogParser](src/main/scala/fundamentals/level04/LogParser.scala) | St |
| 17.00 | End | |

## Pre-requisites

#### 1. Fork or clone this repository

```
$ git clone https://github.com/wjlow/intro-to-scala.git
$ cd intro-to-scala/
```

#### 2. Install Java 8 (do not install Java 9 or Java 10)

##### macOS (using [Homebrew](https://brew.sh))

```
$ brew tap caskroom/versions
$ brew cask install java8
```

#### 3. Install sbt 1.x (recommended but optional, we have included a portable version)

We recommend that you install `sbt` on your machine even though a portable runner is included.

> The actual version of `sbt` used is in your `project/build.properties` file and the global `sbt` is merely used for bootstrapping your project. You should not get conflicting `sbt` installations even if you have multiple Scala projects using different versions of `sbt`.

##### macOS (using [Homebrew](https://brew.sh))

```
$ brew install sbt@1
```

##### Linux
**[Installing sbt on Linux](https://www.scala-sbt.org/1.0/docs/Installing-sbt-on-Linux.html)**

__Tip__: Launching SBT might take some time, so we recommend using SBT's interactive shell to run commands, instead of lauching SBT for each command.

To run the `sbt` shell from the global installation use:

```
$ sbt
```

To run the `sbt` shell from the portable installation use:

```
$ ./sbt
```

#### [4. Compile program to resolve dependencies before the course](#compilation)

#### [5. IDE setup](#ide-setup)

## Compilation

Launch the SBT shell.

To only compile production code use:

```
sbt> compile
```

To compile production and test code use:

```
sbt> test:compile
```

## How to run tests

### To run all tests

To run all tests use:

```
sbt> test
```

The first time you run all the tests you will get a lot of errors! These tests will be fixed by you during the duration of the course.

### Running a single test file

In the meantime, run only a single test case at a time to keep things manageable.

To run a single test, use:

```
sbt> ~testOnly package.path.of.test.TestName
```

For example, to run only the _fundamentals.level01.IntroExercisesTest_ test case, use:

```
sbt> ~testOnly fundamentals.level01.IntroExercisesTest
```

To run by test case name only, use:

```
sbt> ~testOnly *TestName
```

For example, to run the _fundamentals.level01.IntroExercisesTest_ test case, use:

```
sbt> ~testOnly *IntroExercisesTest
```

The `~` watches for changes to your files and runs the command automatically. It's nice to use it to get really fast feedback as you are working on the exercises! 

To stop watching changes through `~`, press <kbd>Enter</kbd> to return to the SBT shell prompt.

## Jumping into a Scala REPL

To launch into a Scala REPL with all production code use:

```
sbt> console
```

To launch into a Scala REPL with all production and test code use:

```
sbt> test:console
```

Type `:q` to exit from the REPL and return to SBT.

## Exiting SBT

To exit the SBT shell use:

```
sbt> exit
```

## IDE setup

<details><summary>IntelliJ IDEA (recommended)</summary>

![intellij](intellij.png)

<p>

1. [Download IntelliJ (free Community edition is fine)](https://www.jetbrains.com/idea/download/#section=mac)

2. Install and open IntelliJ

3. If running IntelliJ for the very first time, it might ask you what plugin you want to install. Select _Scala_, otherwise install manually: _Configure -> Plugins -> Browse Repositories -> Scala_

4. Restart IntelliJ to activate the plugin

5. Open IntelliJ and open this project: _Open -> Select directory where project is in_

6. IntelliJ will detect this as an SBT project. Select `Import SBT Project` when prompted

7. In the pop-up, choose _SDK -> JDK -> Java 1.8_ (this step might be confusing, feel free to reach out)

8. Wait for IntelliJ to refresh the project and download dependencies (this might take a while)

9. Compile project with <kbd>Cmd</kbd> + <kbd>F9</kbd>. If you get no errors, IntelliJ setup is all done!

Tips:

* You can run individual tests by right-clicking and then selecting _Run ...ExercisesTest_ ([or just use SBT](#how-to-run-tests))

* Use <kbd>Cmd</kbd> + <kbd>P</kbd> inside the argument of a function to see what type the argument needs to be.

* Use <kbd>Ctrl</kbd> + <kbd>Shift</kbd> + <kbd>P</kbd> to find out the type of a highlighted expression.

</p></details>

<details><summary>Text Editor (Vim/Sublime/Atom/Emacs)</summary>

![text editor](sublime.png)

<p>

1. Open the current directory in an editor of your choice.

2. Open the SBT shell in a terminal window.

3. Compiling - [See SBT instructions on how to compile code](#compilation).

4. Running Tests - [See SBT instructions on how to run tests](#how-to-run-tests).

5. Looking up Scala API - You can also search through the [Scala APIs](https://www.scala-lang.org/api/current/) to find any necessary methods or use a documentation browser like [Dash](https://kapeli.com/dash).

6. To explore the Scala API or any of the exercises use the Scala REPL - [See SBT instructions on how to jump into the REPL](#jumping-into-a-scala-repl).

![scala api browser](scala-api.png)

</p></details>

## Further documentation

- [Scala API](https://www.scala-lang.org/api/current/)
- [SBT 1.x](https://www.scala-sbt.org/1.x/docs/index.html)
