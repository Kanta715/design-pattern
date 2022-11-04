package FactoryMethod.IDCardForQuestion

import FactoryMethod.Framework.Product
import FactoryMethod.FrameworkForQuestion.FactoryForQuestion

/**
 * Factory の具象クラス
 */
case class IDCardFactoryForQuestion(owners: Seq[String]) extends FactoryForQuestion {

  /**
   * 問2では、通し番号と所持者が対応している list が必要なので、zipWithIndex で index, ownerの名前のタプルを返す
   */
  override lazy val list: Seq[(String, Int)] = owners.zipWithIndex

  /**
   * Product のリストを生成する
   */
  override def createProducts: Seq[Product] = list.map(data => IDCardForQuestion(data._2, data._1))

  override def registerProducts(products: Seq[Product]): Unit =
    for {
      product <- products
    } yield println(s"$product を登録しました")
}
