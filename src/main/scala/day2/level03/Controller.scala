package day2.level03

import cats.effect.IO
import day2.level03.models._

class Controller(dataStore: DataStore) {

  def handleRequest(appRequest: AppRequest): IO[AppResponse] = ???

}
