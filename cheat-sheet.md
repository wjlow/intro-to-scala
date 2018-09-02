### Currying
Converting a function with multiple arguments into a function with a single argument that returns another function.

```scala
def f(a: Int, b: Int): Int // uncurried version (type is (Int, Int) => Int)

def f(a: Int)(b: Int): Int // curried version (type is Int => Int => Int)
```

### Higher Order Functions
A higher order function is a function that can:
- Take one or more functions as arguments
- Return a function as its result

### Lists
The Scala List is an immutable recursive data structure. It is a linked list which is built from “cons” cells `::` and ends in a `Nil` element.
```scala
sealed trait List[+A]

case class ::[A](head: A, tail: List[A]) extends List[A]

case object Nil extends List[Nothing]
```

You can create a list in different ways:
```scala
val list1 = List(1,2,3)

val list2 = 1 :: 2 :: 3 :: Nil

val list3 = ::(1, ::(2, ::(3, Nil)))
```

### foldLeft

The first argument of foldLeft is a seed value `B` to be used for the first element, and the second argument is the function to apply.

```scala
def foldLeft[B](z: B)(op: (B, A) ⇒ B): B
```

Example:
```scala
List(1, 2, 3).foldLeft(20)(_ + _)
// result = 6

List(1, 2, 3).foldLeft(100)(_ + _)
// result = 106
```

### foldRight
The first argument of foldRight is a seed value `B` to be used for the first element, and the second argument is the function to apply.
```scala
def foldRight[B](z: B)(op: (A, B) ⇒ B): B
```

Example:
```scala
List(1, 2, 3).foldRight(0)(_ + _)
// result = 6

List(1, 2, 3).foldRight(100)(_ + _)
// result = 106
```

### Comparison of foldLeft and foldRight order:
`foldLeft` starts on the left side (the first item) and iterates to the right; `foldRight` starts on the right side (the last item) and iterates to the left.

```scala
val list: List[Int] = List(1, 3, 5, 7, 9)

list.foldLeft(0)(_ + _)
// This is the only valid order
0 + 1 = 1
        1 + 3 = 4
                4 + 5 = 9
                        9 + 7 = 16
                                16 + 9 = 25 // done

list.foldRight(0)(_ + _)
// This is the only valid order
1 + (3 + (5 + (7 + (9 + 0))))
1 + (3 + (5 + (7 + 9)))
1 + (3 + (5 + 16))
1 + (3 + 21)
1 + 24
25 // done
```

### Algebraic Data Type (ADT)
ADTs define a fixed set of all possible values of a given type. Two common classes of algebraic types are product types `AND` and sum types `OR`.
For sum types, the number of all its possible values is the sum or disjoint union of the number of all values of the two underlying types.
The values of a product type typically contain several values, called fields. For products types, the number of its possible values is the product of the fields.

Values of algebraic types are analysed with pattern matching, which identifies a value by its constructor or field names and extracts the data it contains.

### Sealed trait
When defining an algebraic data type using sealed traits, it allows the compiler to exhaustively check the possible cases in match expressions.
The compiler will emit a warning (or an error is the option "-Xfatal-warnings" option is enabled) if you have missed a specific case.
The compiler knows all of the subtypes of the trait that can possibly exist as they can only be extended in the file.

```scala
sealed trait MyBooleanType

case object True extends MyBooleanType

case object False extends MyBooleanType
```

### Pattern matching
Pattern matching is a mechanism for checking a value against a pattern. Pattern matching is similar to a series of if/else statements or a switch statement in other languages.

```scala
def numToString(num: Int): String =
  num match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }
```

### map
The .map function on a List applies a function to each element in the List. It works on other data types as well (e.g. Option, Either, etc).

```scala
def map[A,B](fa: F[A])(f: A => B): F[B]

def map[A,B](oa: Option[A])(f: A => B): Option[B]

def map[A,B](ea: Either[A])(f: A => B): Either[B]

def map[A,B](ta: Try[A])(f: A => B): Try[B]
```

### flatMap
flatMap works by applying a function that returns a container type (e.g. a List, Option, Either, etc.) for each element within the container,
and flattening the results into a value of the same container type.

```scala
flatMap[A,B](fa: F[A])(f: A => F[B]): F[B]

flatMap[A,B](oa: Option[A])(f: A => Option[B]): Option[B]

flatMap[A,B](ea: Either[A])(f: A => Either[B]): Either[B]

flatMap[A,B](ta: Try[A])(f: A => Try[B]): Try[B]
```

### For-Comprehensions
A for-comprehension is syntactic sugar for map, flatMap and filter operations on collections.

The general form is `for {s} yield e`
`s` is a sequence of generators and filters
`p <- e` is a generator

For example:
```scala
for {
    x <- Some(3);
    y <- Some(4)
} yield (x + y)

// result = Some(7)
```

is equivalent to:
```scala
Some(3).flatMap(x => Some(4).map(y => x + y))
```


### Option Data Type
The Option data type has two cases: it can be defined (Some), or it can be undefined (None).

```scala
sealed trait Option[+A]

case class Some[+A](get: A) extends Option[A]

case object None extends Option[Nothing]
```

Example:
```scala
def mean(xs: Seq[Double]): Option[Double] =
    if (xs.isEmpty) None
    else Some(xs.sum / xs.length)
```

### Either Data Type
The Either data type has only two cases which both carry a value. Either represents values that can be one of two things.
When we use it to indicate success or failure, by convention the `Right` constructor is reserved for the success case and `Left` is used for failure.

```scala
sealed trait Either[+E, +A]

case class Left[+E](value: E) extends Either[E, Nothing]

case class Right[+A](value: A) extends Either[Nothing, A]
```

Example:
```scala
def mean(xs: IndexedSeq[Double]): Either[String, Double] =
    if (xs.isEmpty) Left("mean of empty list!")
    else Right(xs.sum / xs.length)
```

### Try Data type
The Try type represents a computation that may either result in an exception, or return a successfully computed value

```scala
  def handleAttempt[A](call: Try[A]) = {
    call match {
      case Success(i) => println("Got: " + i)
      case Failure(ex) => println("Failed: " + ex.getMessage)
    }
  }
```

### Scala's Types

![Scala's Class Hierarchy](https://sanj.ink/images/scala_class_hierarchy.png)

|Data Type|Definition|
|---------|----------|
|Boolean|    true or false
|Byte|8-bit signed two's complement integer<br/>(-2^7 to 2^7-1, inclusive) -128 to 127|
|Short|16-bit signed two's complement integer<br/>(-2^15 to 2^15-1, inclusive) 32,768 to 32,767|
|Int|32-bit two's complement integer<br/>(-2^31 to 2^31-1, inclusive) 2,147,483,648 to 2,147,483,647|
|Long|64-bit two's complement integer<br/>(-2^63 to 2^63-1, inclusive) -9,223,372,036,854,775,808 to +9,223,372,036,854,775,807|
|Float|32-bit IEEE 754 single-precision float<br/>1.40129846432481707e-45 to 3.40282346638528860e+38 (positive or negative)|
|Double|64-bit IEEE 754 double-precision float<br/>4.94065645841246544e-324d to 1.79769313486231570e+308d (positive or negative)|
|Char|16-bit unsigned Unicode character<br/>(0 to 2^16-1, inclusive) 0 to 65,535|
|String|a sequence of Chars|

Referenced from [alvinalexander.com](https://alvinalexander.com/scala/scala-data-types-bits-ranges-int-short-long-float-double)
