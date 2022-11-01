package FactoryMethod.IDCard

import FactoryMethod.Framework.Product

case class IDCard(owner: String) extends Product {

  override def use: Unit = println(s"[$this を使います]")

  def toString: String = s"[ IDCard: $owner ]"

  def getOwner: String = owner
}
