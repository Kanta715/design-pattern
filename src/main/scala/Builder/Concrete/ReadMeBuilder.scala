package Builder.Concrete

import Builder.Abstract.Builder

import java.io.{File, FileWriter}

// 問3 他の 具象型の Builder を作る
case class ReadMeBuilder(
  fileName: String,
  file:     File,
  writer:   FileWriter
) extends Builder(fileName, file, writer) {

  override def makeTitle(title: String): Unit = {
    writer.write(s"# $title\n")
  }

  override def makeParagraph(paragraph: String): Unit = {
    writer.write(s"### $paragraph\n")
  }

  override def makeItems(items: Seq[String]): Unit =
    for {
      item <- items
    } yield {
      writer.write(s"- $item\n")
    }

  override def close: Unit = {
    writer.close()
    println("Text file を作成しました!")
    println(s"ファイル名：$fileName")
  }
}

object ReadMeBuilder {

  def create(fileName: String): ReadMeBuilder = {
    val file:   File       = new File(s"src/main/scala/Builder/$fileName.md")
    val writer: FileWriter = new FileWriter(file, true)
    ReadMeBuilder(fileName, file, writer)
  }
}
