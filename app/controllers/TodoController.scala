package controllers

import javax.inject.Inject
import models.Todo
import play.api.libs.json.{Json, OFormat}
import play.api.mvc._
import services.TodoService

import scala.concurrent.ExecutionContext.Implicits.global

class TodoController @Inject()(cc: ControllerComponents, todoService: TodoService) extends AbstractController(cc) {
  implicit val todoFormat: OFormat[Todo] = Json.format[Todo]

  def getAll: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    todoService.getAll map { items =>
      Ok(Json.toJson(items))
    }
  }
}
