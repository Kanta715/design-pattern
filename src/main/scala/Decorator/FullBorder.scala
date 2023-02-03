package Decorator

case class FullBorder(override val display: Display) extends Border(display) {

  override def getRows: Int = display.getRows + 2

  override def getRow(num: Int): String =
    (num == 0 || display.getRows + 1 == num) match {
      case true  => creteDecorate(num, true)
      case false => creteDecorate(num)
    }

  private def creteDecorate(rowNum: Int, isFull: Boolean = false): String = {
    val builder = StringBuilder.newBuilder
    if (isFull) {
      builder append "+"
      (1 to display.getColumns).foreach(_ => builder append  "-")
      builder append  "+"
    }
    if (!isFull) {
      builder append "|"
      builder append display.getRow(rowNum - 1)
      builder append "|"
    }
    builder.toString()
  }

  override def getColumns: Int = display.getColumns + 2
}
