package FactoryMethod.IDCard

import FactoryMethod.Framework.{ Factory, Product }

/**
 * Factory の具象クラス
 */
case class IDCardFactory(owner: String) extends Factory {

  /**
   * Product を生成する
   */
  override def createProduct: Product = IDCard(owner)

  override def registerProduct(product: Product): Unit = println(s"$product を登録しました")
}
