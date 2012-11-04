package controllers

import play.api._
import anorm._
import play.api.mvc._
import play.api.db._
import play.api.Play.current
import models.CoffeeShop
import play.api.data.Form
import play.api.data.Forms.{single, nonEmptyText}


object Site extends Controller {

  def welcome = Action {

    Ok(views.html.welcome())
  }

  def about = Action {

    Ok(views.html.about())
  }


}