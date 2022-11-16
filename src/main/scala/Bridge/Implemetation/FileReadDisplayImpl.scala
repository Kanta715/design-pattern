package Bridge.Implemetation

import scala.io.Source

case class FileReadDisplayImpl(path: String) extends DisplayImpl {

  override def rawOpen: Unit = println("ファイル読み込みを開始")

  override def rawPrint: Unit = {
    val source: Source         = Source.fromFile(path, "utf-8")
    val lines:  Stream[String] = source.getLines.toSeq.toStream
    println("~~~~~~~~~~~~~~~~~~~")
    lines.foreach(println(_))
    println("~~~~~~~~~~~~~~~~~~~")
  }

  override def rawClose: Unit = println("ファイル出力完了")
}
