package Visitor

object ListVisitor extends Visitor {
  override def visit(file: File):      Unit = print(s"${file.name}(${file.size})")
  override def visit(dir:  Directory): Unit = {
    print(s"/${dir.name}(${dir.size})")
    for {
      entry <- dir.member
    } yield {
      entry.accept(this)
    }
  }
}
