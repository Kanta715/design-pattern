package Decorator

case class StringDisplay(str: String) extends Display {

  override def getRows: Int = 1

  // エラーは返したくないので、絶対に str を返すようにしている
  override def getRow(num: Int): String = str

  override def getColumns: Int = str.length

  override def show: Unit = println(str)
}
