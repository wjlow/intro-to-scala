package introcourse

package object level04 {

  case class Person(name: String, age: Int)

  sealed trait TrafficLight

  case object Red extends TrafficLight

  case object Yellow extends TrafficLight

  case object Green extends TrafficLight

}
