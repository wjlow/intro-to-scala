# Try Samples

```scala
//Either
def evenE(n: Int): Either[String, Int] = if (n % 2 == 0) Right(n) else Left (s"$n is not even")
```

```scala
import scala.util._

def evenT(n: Int): Try[Int] = if (n % 2 == 0) Success(n) else Failure (new RuntimeException(s"$n is not even"))
```

```scala
val t1 =
  for {
    one <- evenT(10)
    two <- evenT(20)
    three <- evenT(30)
  } yield one + two + three
```

```scala
val t2 =
  for {
    one <- evenT(10)
    two <- evenT(20)
    three <- evenT(31)
  } yield one + two + three
```

```scala
val t3 =
  for {
    one <- evenT(1)
    two <- evenT(20)
    three <- evenT(30)
  } yield one + two + three
```
