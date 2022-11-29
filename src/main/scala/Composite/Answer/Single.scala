package Composite.Answer

import java.time.LocalDate

case class Single(override val name: String, birthday: LocalDate = LocalDate.now()) extends Person(name, birthday) {

  override def getDescendantsNames: Seq[String] = Seq.empty

  override def printInfo: Unit = {
    println(s"${birthday.toString}: $name")
  }
}
