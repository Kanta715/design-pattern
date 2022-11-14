package Builder

import java.io.{ File, FileWriter }

abstract class Builder(fileName: String, file: File, writer: FileWriter) {
  def makeTitle    (title:     String):      Unit
  def makeParagraph(paragraph: String):      Unit
  def makeItems    (items:     Seq[String]): Unit
  def close:                                 Unit
}
