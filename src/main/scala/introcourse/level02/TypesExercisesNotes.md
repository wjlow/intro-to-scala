```
//case class
case class Person(name: String, age: Int)

//didn't use *new* operator
val jack = Person("Jack", 35)
jack.name
jack.age
jack.toString

jack.age = 28

val realJack = jack.copy(age = 28)

jack == jack
realJack == jack


jack match {
    case Person(name, age) => s"Hello $name, you are $age yonks old"
}
```
