# For Comprehension

For Comprehension is a powerful technique for working with values in "containers", e.g. `Option`, `Either`, `Try`, `List`, etc.

Here are some examples of for comprehension usages. Run them in a REPL and see what they output. You can start up a REPL with `./auto/sbt console`.

## Option

```
case class Person(name: String, age: Int)

val result1: Option[Person] = 
  for {
    name <- Some("Bob")
    age  <- Some(20)
  } yield Person(name, age)

println(result1)

val result2: Option[Person] = 
  for {
    name <- Some("Bob")
    age  <- None
  } yield Person(name, age)

println(result2)
```

## Either

```
case class Person(name: String, age: Int)

case class MyError(msg: String)

val result1: Either[MyError, Person] = 
  for {
    name <- Right("Bob")
    age  <- Right(20)
  } yield Person(name, age)

println(result1)

val result2: Either[MyError, Person] = 
  for {
    name <- Left(MyError("empty name"))
    age  <- Right(20)
  } yield Person(name, age)

println(result2)
```

## Try

```
import scala.util.Try

val result1 = 
  for {
    one    <- Try("1".toInt)
    twenty <- Try("20".toInt)
  } yield (one + twenty)

println(result1)

val result2 = 
  for {
    one    <- Try("one".toInt)
    twenty <- Try("20".toInt)
  } yield (one + twenty)

println(result2)
```