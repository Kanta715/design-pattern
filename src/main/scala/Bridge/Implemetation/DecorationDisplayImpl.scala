package Bridge.Implemetation

case class DecorationDisplayImpl(
  startDeco: Char,
  mainDeco:  Char,
  endDeco:   Char
) extends DisplayImpl {

  override def rawOpen: Unit = Console.print(s"$startDeco")

  override def rawPrint: Unit = Console.print(s"$mainDeco")

  override def rawClose: Unit = println(s"$endDeco")
}
