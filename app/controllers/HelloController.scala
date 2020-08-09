package controllers

import javax.inject.Inject
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}

import scala.util.chaining.scalaUtilChainingOps


class HelloController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def hello(): Action[AnyContent] = Action(Ok("Hello world"))

  def helloJson(): Action[AnyContent] = Action {
    Json.obj("hello" -> "world", "language" -> "scala").pipe { it =>
      Ok(it)
    }
  }
}
