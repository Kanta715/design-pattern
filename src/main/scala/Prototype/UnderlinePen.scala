package Prototype

import Prototype.Framework.Product

case class UnderlinePen(underline: Char) extends Product {

  override def use(message: String): Unit = {
    val width = message.length
    println(message)
    printUnderline(width)
  }

  def printUnderline(width: Int): Unit = {
    for (n <- 1 to width) {
      Console.print(underline)
    }
    println("")
  }

  // Scala の case class には copy メソッドがあるため clone メソッドは不要
}
