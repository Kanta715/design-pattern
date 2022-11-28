package Composite

case class File(override val name: String, size: Int) extends Entry(name) {

  override def getSize: Int = size

  override def printInfo: Unit =
    println(s"$name($size)")
}
