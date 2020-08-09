package models

import javax.inject.Inject
import play.api.data.Form
import play.api.data.Forms.{boolean, mapping, nonEmptyText}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import slick.jdbc.PostgresProfile.api._
import slick.lifted.ProvenShape

import scala.concurrent.{ExecutionContext, Future}

case class Todo(id: Long, name: String, isComplete: Boolean)

case class TodoFormData(name: String, isComplete: Boolean)

object TodoForm {
  val form: Form[TodoFormData] = Form(
    mapping(
      "name" -> nonEmptyText,
      "isComplete" -> boolean
    )(TodoFormData.apply)(TodoFormData.unapply)
  )
}

class TodoTable(tag: Tag) extends Table[Todo](tag, "todo") {
  override def * : ProvenShape[Todo] = (id, name, isComplete) <> (Todo.tupled, Todo.unapply)

  def id: Rep[Long] = column[Long]("id", O.PrimaryKey, O.AutoInc)

  def name: Rep[String] = column[String]("name")

  def isComplete: Rep[Boolean] = column[Boolean]("iscomplete")
}

class TodoList @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] {
  var todoList: TableQuery[TodoTable] = TableQuery[TodoTable]

  def listAll: Future[Seq[Todo]] = {
    dbConfig.db.run(todoList.result)
  }
}
