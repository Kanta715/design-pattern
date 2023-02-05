package Visitor

trait Visitor {
  def visit(file: File)
  def visit(der:  Directory)
}
