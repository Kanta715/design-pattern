package FactoryMethod.FrameworkForQuestion

import FactoryMethod.Framework.Product

abstract class FactoryForQuestion {

  /**
   * 通し番号と所持者の対応表を持つように強制
   */
  var list: Seq[(String, Int)]

  def createProducts(owners: Seq[String]): Seq[Product]

  def registerProducts(owner: String): Product
}
