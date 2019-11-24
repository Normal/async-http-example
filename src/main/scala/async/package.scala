package object async {

  case class Company(name: String, catchPhrase: String, bs: String)

  case class Geo(lat: String, lng: String)

  case class Address(
                      street: String,
                      suite: String,
                      city: String,
                      zipcode: String,
                      geo: Geo
                    )

  case class UserData(
                       id: Long,
                       name: String,
                       email: String,
                       phone: String,
                       website: String,
                       company: Company,
                       address: Address
                     )

  case class Post(userId: Long, id: Long, title: String, body: String)

  case class Result(user: UserData, posts: Array[Post])

}
