package Composite.Answer

import java.time.LocalDate

case class Married(
  override val name: String,
           birthday: LocalDate   = LocalDate.now(),
           children: Seq[Person] = Seq.empty
) extends Person(name, birthday) {

  override def getDescendantsNames: Seq[String] =
    children.map(_.name)

  override def printInfo: Unit = {
    println(s"${birthday.toString}: $name")
    println(s"children:")
    for {
      name <- getDescendantsNames
    } yield println(s"  $name")
    for {
      descendant <- children
    } yield descendant.printInfo
  }

  def add(person: Person): Married = {
    val removed = children.filterNot(_.name == person.name)
    val updated = removed :+ person
    this.copy(name, birthday, updated)
  }
}