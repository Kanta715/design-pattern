package Builder.Abstract

import java.io.{File, FileWriter}

// 問1 Builder を trait に
trait BuilderOfTrait {

  val fileName: String
  val file: File
  val writer: FileWriter

  def makeTitle(title: String): Unit

  def makeParagraph(paragraph: String): Unit

  def makeItems(items: Seq[String]): Unit

  def close: Unit
}
