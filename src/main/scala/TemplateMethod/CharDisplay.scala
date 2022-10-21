package TemplateMethod

/**
 * Char型の文字を5回出力してくれるクラス
 */
private case class CharDisplay(char: Char) extends AbstractDisplay {

  override def open(): Unit = Console.out.print("<< ")

  override def print(): Unit = Console.out.print(s"$char")

  override def close(): Unit = println(" >>")
}
