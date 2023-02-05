package Visitor

case class File(override val name: String, override val size: Int) extends Entry(name, size) {
  override def accept(visitor: Visitor): Unit = visitor.visit(this)
}
