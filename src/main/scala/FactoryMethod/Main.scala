package FactoryMethod

import FactoryMethod.Framework.{ Factory, Product }
import FactoryMethod.IDCard.IDCardFactory

import FactoryMethod.FrameworkForQuestion.FactoryForQuestion
import FactoryMethod.IDCardForQuestion.IDCardFactoryForQuestion

object Main {

  def main(args: Array[String]): Unit = {
    val DEFAULT_OWNER: String = "DEFAULT_OWNER"

    val owner:   String  = args.toSeq.headOption.getOrElse(DEFAULT_OWNER)
    val factory: Factory = IDCardFactory(owner)
    val idCard:  Product = factory.createProduct
    idCard.use

    println("")
    println("========== [ 練習問題用 ]==========")
    println("")

    val DEFAULT_OWNERS: Seq[String] = Seq("DEFAULT_OWNER 1", "DEFAULT_OWNER 2", "DEFAULT_OWNER 3")

    val owners:             Seq[String]        = if (args.isEmpty) DEFAULT_OWNERS else args.toSeq
    val factoryForQuestion: FactoryForQuestion = IDCardFactoryForQuestion(owners)
    val idCards:            Seq[Product]       = factoryForQuestion.createProducts

    println("----- [ 通し番号と所持者の対応表 ] -----")
    println(factoryForQuestion.list)
    println("")
    println("Product のリスト")
    println(idCards)
  }
}
