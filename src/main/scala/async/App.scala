package async

import org.json4s.DefaultFormats
import org.json4s.jackson.JsonMethods
import org.json4s.jackson.Serialization.writePretty

import scala.concurrent.Future
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

object App {

  val USER_DATA_URL = "http://jsonplaceholder.typicode.com/users/"
  val POSTS_URL = "http://jsonplaceholder.typicode.com/posts?userId="

  implicit val jsonDefaultFormats: DefaultFormats.type = DefaultFormats

  def main(args: Array[String]): Unit = {
    val userId = args.head

    val result: Future[Result] = for {
      data <- fetchUserData(userId)
      posts <- fetchUserPosts(userId)
    } yield Result(data, posts)

    result.onComplete {
      case Success(value) => println(writePretty(value))
      case Failure(exc) => println(exc)
    }

    // wait for all threads to finish and shutdown application
    Thread.sleep(1000L)
    System.exit(0)
  }

  def fetchUserData(userId: String): Future[UserData] = {
    val content: Future[String] = HttpClient.fetchAsString(s"$USER_DATA_URL$userId")
    content.map(c => JsonMethods.parse(c).extract[UserData])
  }

  def fetchUserPosts(userId: String): Future[Array[Post]] = {
    val content: Future[String] = HttpClient.fetchAsString(s"$POSTS_URL$userId")
    content.map(c => JsonMethods.parse(c).extract[Array[Post]])
  }
}
