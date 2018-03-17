package applied

import cats.effect.{IO, Sync}
import io.circe.Decoder
import org.http4s.EntityDecoder
import org.http4s.circe.jsonOf

package object level03 {

  def toAppResponse[A, B](io: IO[Either[String, A]], f: A => B): IO[Either[String, B]] =
    io.map(_.map(f))

  /**
    * Treat every HTTP entity as JSON and convert them to a typed model `A`
    * This allows using `.as[MyModel]` on a `Request` to convert a JSON to a `MyModel`
    * using the field names of `MyModel`.
    *
    * e.g. Provided `case class MyModel(key1: String, key2: String)`
    * `{ "key1": "value1", "key2": "value2"}` becomes `MyModel("value1", value2")`
    */
  implicit def decoders[F[_]: Sync, A: Decoder]: EntityDecoder[F, A] = jsonOf[F, A]

}
