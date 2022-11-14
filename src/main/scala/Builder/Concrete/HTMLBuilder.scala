package Builder

import java.io.{ File, FileWriter }

case class HTMLBuilder(
  fileName: String,
  file:     File,
  writer:   FileWriter
) extends Builder(fileName, file, writer) {

  override def makeTitle(title: String): Unit = {
    writer.write("<!DOCTYPE html>\n")
    writer.write("<html>\n")
    writer.write(s"<head>\n<title>\n$title\n")
    writer.write("</title>\n</head>\n")
    writer.write("<body>\n")
    writer.write(s"<h1>『 $title 』</h1>\n")
  }

  override def makeParagraph(paragraph: String): Unit = {
    writer.write(s"<p>■ $paragraph</p>\n")
  }

  override def makeItems(items: Seq[String]): Unit = {
    writer.write("<ul>\n")
    for {
      item <- items
    } yield {
      val link = s"https://github.com/Kanta715/design-pattern/tree/main/src/main/scala/$item"
      writer.write(s"<li><a href=$link>$item</a></li>\n")
    }
    writer.write("</ul>\n")
  }

  override def close: Unit = {
    writer.write("</body>\n")
    writer.write("</html>\n")
    writer.close()
    println("Text file を作成しました!")
    println(s"ファイル名：$fileName")
  }
}

object HTMLBuilder {

  def create(fileName: String): HTMLBuilder = {
    val file:   File       = new File(s"src/main/scala/Builder/$fileName.html")
    val writer: FileWriter = new FileWriter(file, true)
    HTMLBuilder(fileName, file, writer)
  }
}
