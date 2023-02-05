package Visitor

trait Element {
  def accept(visitor: Visitor): Unit
}
