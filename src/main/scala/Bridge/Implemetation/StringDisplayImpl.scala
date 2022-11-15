package Bridge.Implemetation

case class StringDisplayImpl(str: String) extends DisplayImpl {

  lazy val width: Int = str.length

  override def rawOpen: Unit = printFrame

  override def rawPrint: Unit = println(s"|$str|")

  override def rawClose: Unit = printFrame


  def printFrame: Unit = {
    Console.print("+")
    for (n <- 1 to width) {
      Console.print("-")
    }
    println("+")
  }
}
