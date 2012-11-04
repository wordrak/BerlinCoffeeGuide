package controllers

import anorm._
import play.api.mvc._
import models.CoffeeShop
import play.api.data.Form
import play.api.data.Forms.{single, nonEmptyText}


object CoffeeShops extends Controller {

  def search = Action {

    val result: Seq[CoffeeShop] = CoffeeShop.findAll()

    Ok(views.html.coffeeshops.search(result, coffeeShopForm))
  }

  def addCoffeeShop = Action {implicit request =>
    coffeeShopForm.bindFromRequest.fold(
      errors => BadRequest,
      {
        case (name) =>
          CoffeeShop.create(CoffeeShop(NotAssigned, name, name, name, name))
          Redirect(routes.CoffeeShops.search())
      }
    )
  }

  val coffeeShopForm = Form(
    single("name" -> nonEmptyText)
  )

}