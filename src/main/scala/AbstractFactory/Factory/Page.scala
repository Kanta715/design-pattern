package AbstractFactory.Factory

import java.io.{ File, FileWriter }

abstract class Page(
  title:   String,
  author:  String,
  content: Seq[Item]
) {

  def add(item: Item): Page

  def output: Unit = {
    val file:   File       = new File(s"src/main/scala/AbstractFactory/$title.html")
    val writer: FileWriter = new FileWriter(file)
    writer.write(makeHTML)
    writer.close()
    println("ファイルを作成しました")
    println(s"ファイル名: $title.html")
  }

  def makeHTML: String
}
