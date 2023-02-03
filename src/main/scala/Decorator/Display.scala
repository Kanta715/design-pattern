package Decorator

trait Display {

  def getColumns: Int

  def getRows: Int

  def getRow(num: Int): String

  def show: Unit = {
    val num     = getRows - 1
    val builder = StringBuilder.newBuilder
    (0 to num).foreach(n => {
      val row = getRow(n)
      builder append(row + "\n")
    })
    println(builder.toString())
  }
}
