package FactoryMethod.IDCardForQuestion

import FactoryMethod.Framework.Product

/**
 * 問2では、通し番号(serial number)を各クラスに持たせるよう指示が出ているため、sn をコンストクタ引数に追加
 */
case class IDCardForQuestion(sn: Int, owner: String) extends Product {

  override def use: Unit = println(s"[$this を使います]")

  override def toString: String = s"[ IDCard: $owner ]"

  def getOwner: String = owner
}
