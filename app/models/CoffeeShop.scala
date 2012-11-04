package models

import play.api.db._
import play.api.Play.current

import anorm._
import anorm.SqlParser._

case class CoffeeShop(id: Pk[Long],
                      name: String,
                      street: String,
                      zipCode: String,
                      city: String)

object CoffeeShop {

  val parser = {
    get[Pk[Long]]("id") ~
      get[String]("name") ~
      get[String]("street") ~
      get[String]("zipCode") ~
      get[String]("city") map {
      case id~name~s~z~c => CoffeeShop(id, name, s, z, c)
    }
  }

  def findAll(): Seq[CoffeeShop] = {
    DB.withConnection { implicit connection =>
      SQL("select * from CoffeeShop").as(CoffeeShop.parser *)
    }
  }

  def create(coffeeShop: CoffeeShop) {
    DB.withConnection { implicit connection =>
      SQL("INSERT INTO CoffeeShop(name, street, zipCode, city) values ({name}, {street}, {zipCode}, {city})")
        .on(
        'name -> coffeeShop.name,
        'street -> coffeeShop.street,
        'zipCode -> coffeeShop.zipCode,
        'city -> coffeeShop.city)
        .executeInsert()
    }
  }

}