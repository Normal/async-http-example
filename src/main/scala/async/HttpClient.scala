package async

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object HttpClient {

  def fetchAsString(path: String): Future[String] = {
    import dispatch.url
    import dispatch.Http
    import dispatch.as

    val svc = url(path)
    Http.default(svc OK as.String)
  }

}
