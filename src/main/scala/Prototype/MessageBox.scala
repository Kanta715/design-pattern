package Prototype

import Prototype.Framework.Product

case class MessageBox(decoChar: Char) extends Product {

  // 問2: コピーコンストラクタを実装
  // Java の clone は浅いコピーらしく scala の copy はどうやってるんだろうと思ったけどこんな感じなのかな
  lazy val messageBoxCopy: MessageBox = MessageBox(decoChar)

  override def use(message: String): Unit = {
    val width = message.length + 4
    printFrame(width)
    println(s"$decoChar " + message + s" $decoChar")
    printFrame(width)
  }

  def printFrame(width: Int): Unit = {
    for (n <- 1 to width) {
      Console.print(decoChar)
    }
    println("")
  }

  // Scala の case class には copy メソッドがあるため clone メソッドは不要
}
