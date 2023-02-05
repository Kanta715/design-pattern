package Visitor

case class Directory(
  override val name:   String,
  override val size:   Int,
               member: Seq[Entry]
) extends Entry(name, size) {

  override def accept(visitor: Visitor): Unit = visitor.visit(this)

  def add(entry: Entry): Directory = this.copy(size = size + entry.size, member = member :+ entry)
}
