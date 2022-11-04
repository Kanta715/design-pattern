package FactoryMethod.FrameworkForQuestion

import FactoryMethod.Framework.Product

abstract class FactoryForQuestion {

  /**
   * 通し番号と所持者の対応表を持つように強制
   */
  val list: Seq[(String, Int)]

  def createProducts: Seq[Product]

  def registerProducts(products: Seq[Product]): Unit
}
