package TemplateMethod

/**
 * String型の文字列を5回出力してくれるクラス
 */
case class StringDisplay(string: String) extends AbstractDisplay {

  override def open(): Unit = printFlame(string)

  override def print(): Unit = println(s"|$string|")

  override def close(): Unit = printFlame(string)

  private def printFlame(string: String): Unit = {
    val charNum = string.size
    Console.out.print("+")
    for (num <- 1 to charNum) {
      Console.out.print("-")
    }
    println("+")
  }
}
