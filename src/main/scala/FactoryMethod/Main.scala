package FactoryMethod

import FactoryMethod.Framework.{ Factory, Product }
import FactoryMethod.IDCard.IDCardFactory

object Main {

  def main(args: Array[String]): Unit = {
    val DEFAULT_OWNER: String = "DEFAULT_OWNER"

    val owner:   String  = args.toSeq.headOption.getOrElse(DEFAULT_OWNER)
    val factory: Factory = IDCardFactory(owner)
    val idCard:  Product = factory.createProduct
    idCard.use
  }
}
