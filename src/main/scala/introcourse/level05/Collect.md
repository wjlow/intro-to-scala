# Collect Sample


```
val numbers = (1 to 10).toList

def evenO(n: Int): Option[Int] = if (n % 2 == 0) Some(n) else None

val opEvens = numbers.map(evenO)
```

```
//Only evens
opEvens.filter(_.isDefined)
```

```
//filter evens and multiply by 10
opEvens.filter(_.isDefined).map(_.map(_ * 10))
```


```
//filter evens and multiply by 10
opEvens.collect {
    case Some(v) => v * 10
}
```
