### Currying
Converting a function with multiple arguments into a function with a single argument that returns another function.

```
def f(a: Int, b: Int): Int // uncurried version (type is (Int, Int) => Int)

def f(a: Int)(b: Int): Int // curried version (type is Int => Int => Int)
```

### Higher Order Functions
A higher order function is a function that can:
- Take one or more functions as arguments
- Return a function as its result

### Lists
The Scala List is an immutable recursive data structure. It is a linked list which is built from “cons” cells `::` and ends in a `Nil` element.
```
sealed trait List[+A]

case class ::[A](head: A, tail: List[A]) extends List[A]

case object Nil extends List[Nothing]
```

You can create a list in different ways:
```
val list1 = List(1,2,3)

val list2 = 1 :: 2 :: 3 :: Nil

val list3 = ::(1, ::(2, ::(3, Nil)))
```

### fold
The fold method for a List takes two arguments; the start value and a function. This function also takes two arguments; the accumulated value and the current item in the list. 

```
def fold[A1 >: A](z: A1)(op: (A1, A1) ⇒ A1): A1
```

Example:
```
val numbers = List(5, 4, 8, 6, 2)
numbers.fold(0) { (z, i) =>
  a + i
}
// result = 25
```

At the start of execution, the start value that you passed as the first argument is given to your function as its first argument. As the function's second argument, it is given the first item on the list (in the case of fold this may or may not be the actual first item on your list).
1. The function is then applied to its two arguments, in this case an addition, and returns the result.
2. Fold then gives the function the previous return value as its first argument and the next item in the list as its second argument, and applies it, returning the result.
3. This process repeats for each item of the list and returns the return value of the function once all items in the list have been iterated over.

### foldLeft

The first argument of foldLeft is a seed value `B` to be used for the first element, and the second argument is the function to apply.

```
def foldLeft[B](z: B)(op: (B, A) ⇒ B): B
```

Example:
```
List(1, 2, 3).foldLeft(20)(_ + _)
// result = 6

List(1, 2, 3).foldLeft(100)(_ + _)
// result = 106
```

### foldRight
The first argument of foldRight is a seed value `B` to be used for the first element, and the second argument is the function to apply.
```
def foldRight[B](z: B)(op: (A, B) ⇒ B): B
```

Example:
```
List(1, 2, 3).foldRight(0)(_ + _)
// result = 6

List(1, 2, 3).foldRight(100)(_ + _)
// result = 106
```

### Comparison of fold, foldLeft and foldRight order:
`foldLeft` starts on the left side (the first item) and iterates to the right; `foldRight` starts on the right side (the last item) and iterates to the left; `fold` has no particular order.

```
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
0 + 9 = 9
        9 + 7 = 16
                16 + 5 = 21
                         21 + 3 = 24
                                  24 + 1 = 25 // done

list.fold(0)(_ + _) // 25
// One of the many valid orders
0 + 1 = 1    0 + 3 = 3             0 + 5 = 5
        1            3 + 7 = 10            5 + 9 = 14    
        1                    10          +         14 = 24
        1                        +                      24 = 25 // done

```

### Algebraic Data Type (ADT)
ADTs define a fixed set of all possible values of a given type. Two common classes of algebraic types are product types `AND` and sum types `OR`. 
For sum types, the number of all its possible values is the sum or disjoint union of the number of all values of the two underlying types. 
The values of a product type typically contain several values, called fields. For products types, the number of its possible values is the product of the fields.

Values of algebraic types are analysed with pattern matching, which identifies a value by its constructor or field names and extracts the data it contains.

### Sealed trait
When defining an algebraic data type using sealed traits, it allows the compiler to exhaustively check the possible cases in match expressions. The compiler will emit a warning if the match expression isn’t exhaustive. The compiler knows all of the subtypes of the trait that can possibly exist as they can only be extended in the file. 

```
sealed trait Boolean

case object True extends Boolean

case object False extends Boolean
```

### Pattern matching
Pattern matching is a mechanism for checking a value against a pattern. Pattern matching is similar to a series of if/else statements or a switch statement in other languages.

```
def numToString(num: Int): String =
  num match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }
```

### map
Map works by applying a function to each element in the list.

```
def map[A,B](fa: F[A])(f: A => B): F[B]

def map[A,B](oa: Option[A])(f: A => B): Option[B]

def map[A,B](ea: Either[A])(f: A => B): Either[B]

def map[A,B](ta: Try[A])(f: A => B): Try[B]
```

###flatMap
flatMap works by applying a function that returns a sequence for each element in the list, and flattening the results into the original list.

```
flatMap[A,B](fa: F[A])(f: A => F[B]): F[B]

flatMap[A,B](oa: Option[A])(f: A => Option[B]): Option[B]

flatMap[A,B](ea: Either[A])(f: A => Either[B]): Either[B]

flatMap[A,B](ta: Try[A])(f: A => Try[B]): Try[B]
```

###For-Comprehensions
A for-comprehension is syntactic sugar for map, flatMap and filter operations on collections.

The general form is `for {s} yield e`
`s` is a sequence of generators and filters
`p <- e` is a generator
`if f` is a filter

For example:
```
for {
    x <- Some(3);
    y <- Some(4)
} yield (x + y)

// result = Some(7)
```

is equivalent to:
```
Some(3).flatMap(x => Some(4).map(y => x + y))
```


### Option Data Type
The Option data type has two cases: it can be defined (Some), or it can be undefined (None).

```
sealed trait Option[+A]

case class Some[+A](get: A) extends Option[A]

case object None extends Option[Nothing]
```

Example:
```
def mean(xs: Seq[Double]): Option[Double] =
    if (xs.isEmpty) None
    else Some(xs.sum / xs.length)
```

### Either Data Type
The Either data type has only two cases which both carry a value. Either represents values that can be one of two things. 
When we use it to indicate success or failure, by convention the `Right` constructor is reserved for the success case and `Left` is used for failure.

```
sealed trait Either[+E, +A]

case class Left[+E](value: E) extends Either[E, Nothing]

case class Right[+A](value: A) extends Either[Nothing, A]
```

Example:
```
def mean(xs: IndexedSeq[Double]): Either[String, Double] =
    if (xs.isEmpty) Left("mean of empty list!")
    else Right(xs.sum / xs.length)
```

### Try Data type
The Try function is a general-purpose function we can use to convert from an exception-based API to an Option or Either data type. 
This uses a non-strict or lazy argument, as indicated by the => A as the type of a.

```
def Try[A](a: => A): Option[A] =
  try Some(a)
  catch { case e: Exception => None }
```

```
def Try[A](a: => A): Either[Exception, A] =
  try Right(a)
  catch { case e: Exception => Left(e) }
```