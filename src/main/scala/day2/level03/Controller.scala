package day2.level03

import day2.level03.models._

import cats.effect.IO

class Controller(dataStore: DataStore) {

  /**
    * Call functions defined on `DataStore` and construct an `AppResponse` for each possible `AppRequest`
    *
    * Hint: Pattern match on `appRequest`
    */
  def handleRequest(appRequest: AppRequest): IO[AppResponse] = ???

}
