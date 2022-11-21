package FactoryMethod.IDCard

import FactoryMethod.Framework.{ Factory, Product }

/**
 * Factory の具象クラス
 */
object IDCardFactory extends Factory {

  /**
   * Product を生成する
   */
  override def createProduct(owner: String): Product = IDCard(owner)

  override def registerProduct(product: Product): Unit = println(s"$product を登録しました")
}
