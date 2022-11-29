package Composite.Answer

import java.time.LocalDate

abstract class Person(val name: String, birthday: LocalDate) {

  def getDescendantsNames: Seq[String]
  def printInfo:           Unit

}
