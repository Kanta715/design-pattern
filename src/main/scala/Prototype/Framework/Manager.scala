package Prototype.Framework

import scala.collection.Map

case class Manager(productMap: Map[String, Product] = Map.empty) {

  def register(name: String, product: Product): Manager = {
    val keys: Seq[String] = productMap.keys.toSeq
    keys.contains(name) match {
      case true  => throw new IllegalArgumentException("すでに存在する名前の製品です")
      case false => this.copy(productMap + (name -> product))
    }
  }

  // サンプルコードの create よりも登録したものを取得する感じの方がしっくりくるので find
  def find(name: String): Product = {
    val product: Option[Product] = productMap.get(name)
    product match {
      case Some(item) => item
      case None       => throw new IllegalAccessError("指定した名前で登録されている製品は存在しません")
    }
  }
}

// サンプルコードのようにシングルトンとして扱いたいならオブジェクトで書く
// コンパイル通してないのであってるかわからない
// object Manager {
//
//  var productMap: Map[String, Product] = Map.empty
//
//  def add(name: String, product: Product): Unit =
//    productMap + (name -> product)
//
//  def find(name: String): Product = {
//    val product: Option[Product] = productMap.get(name)
//    product match {
//      case Some(item) => item
//      case None       => throw new IllegalAccessError("指定した名前で登録されている製品は存在しません")
//    }
//  }
//}
