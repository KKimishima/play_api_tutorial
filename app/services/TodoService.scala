package services

import javax.inject.Inject
import models.{Todo, TodoList}

import scala.concurrent.Future

class TodoService @Inject()(items: TodoList) {
  def getAll: Future[Seq[Todo]] = items.listAll
}
