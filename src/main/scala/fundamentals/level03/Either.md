# Either Samples

```
def evenE(n: Int): Either[String, Int] = if (n % 2 == 0) Right(n) else Left (s"$n is not even")
```

```
val e1 =
  for {
    one <- evenE(10)
    two <- evenE(20)
    three <- evenE(30)
  } yield one + two + three
```

```
val e2 =
  for {
    one <- evenE(10)
    two <- evenE(20)
    three <- evenE(31)
  } yield one + two + three
```

```
val e3 =
  for {
    one <- evenE(1)
    two <- evenE(20)
    three <- evenE(30)
  } yield one + two + three
```
