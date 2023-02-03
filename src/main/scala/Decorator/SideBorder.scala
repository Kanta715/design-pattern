package Decorator

case class SideBorder(override val display: Display) extends Border(display) {

  override def getRows: Int = display.getRows

  override def getRow(num: Int): String = "|" +  display.getRow(num) + "|"

  override def getColumns: Int = display.getColumns + 2
}
