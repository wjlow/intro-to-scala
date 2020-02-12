val list1: List[Int] = Nil
val list2 = 1 :: Nil
val list3 = ::(1, Nil)
val list4 = (2 ::(1 :: Nil))

val list5 = List.apply(1,2,3)

val list6 = List(1,2,3)

def product(nums: List[Int]): Int = {
  nums.foldLeft(1){(cur,acc) => acc * cur}
}

nums match {
-      case Nil => ???
  -      case head :: tail => ???
  +      case Nil => Int.MinValue
  +      case head :: tail => tail.foldLeft(head){(acc, cur) => if(cur < acc) {cur} else {acc}}
}


-  def youngestPerson(persons: List[Person]): Person = ???
+  def youngestPerson(persons: List[Person]): Person = {
  +    persons match {
  +      case Nil => Person("Nobody",0)
    +      case (head::tail) => persons.foldLeft(Person("Nobody", Int.MaxValue)){(acc, cur) => if (cur.age < acc.age){cur} else {acc}}
    +//      case _ => persons.reduce((acc, cur) => if (acc.age <= cur.age) acc else cur)
    +    }
  +  }


def youngestPerson(persons: List[Person]): Person = {
  persons match {
    case Nil => Person("Nobody", 0)
    case (head :: tail) => tail.foldLeft(head){(acc, cur) => if (acc.age <= cur.age) acc else cur}
  }

}


-  def personWithIndex(people: List[Person]): List[(Person, Int)] = ???
+  def personWithIndex(people: List[Person]): List[(Person, Int)] = {
  +    people.zipWithIndex.map(p => (Person(p._1.name, p._1.age), p._2+1))
  +    //destructuring tuples
    +  }


def showEveryNthPerson(n: Int, persons: List[Person]): List[String] = {
  if (n > persons.length) {
    return Nil
  }

  if (n <= 0) {
    return persons.map(person => showPerson(person))
  }

  val filteredPersons = personWithIndex(persons).filter{ personIndexTuple => {
    personIndexTuple._2 % n == 0
  }}

  filteredPersons.map(personIndexTuple => {showPerson(personIndexTuple._1)})
}




list1 match {
  case list@(head :: tail) => {
    val newList = (head::tail)
    println("Not empty")
    list

  }
  case Nil => {
    println("empty")
    Nil
  }
}


//
//
//
////Pattern matching on a list
//val result: List[Int] = list3 match {
//  case list@(head::tail) => {
//    println(s"head $head")
//    println(s"tail $tail")
//    list
//  }
//  case Nil => {
//    println("This is the empty list")
//    Nil
//  }
//}
//
//println(result)
//
////Tuples
//
//val x = ("key", "value")
//val (key, value) = x
//println(s"key is ${x._1}, value is ${x._2}")
//println(s"key is $key, value is $value")
