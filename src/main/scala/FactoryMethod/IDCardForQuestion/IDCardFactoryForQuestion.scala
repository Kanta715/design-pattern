package FactoryMethod.IDCardForQuestion

import FactoryMethod.Framework.Product
import FactoryMethod.FrameworkForQuestion.FactoryForQuestion

/**
 * Factory の具象クラス
 */
object IDCardFactoryForQuestion extends FactoryForQuestion {

  /**
   * 問2では、通し番号と所持者が対応している list が必要なので、zipWithIndex で index, ownerの名前のタプルを返す
   */
  var list: Seq[(String, Int)] = Seq.empty

  /**
   * Product のリストを生成する
   */
  override def createProducts(owners: Seq[String]): Seq[Product] = {
    list = list ++ owners.zipWithIndex.map(values => (values._1, values._2 + list.size))
    list.map(v => IDCardForQuestion(v._2, v._1))
  }

  override def registerProducts(owner: String): Product = {
    val product = IDCardForQuestion(list.size, owner)
    list = list ++ Seq((product.owner, product.sn))
    println(s"通し番号: ${list.size}, オーナー名: $owner の IDCard を作成しました")
    product
  }
}
