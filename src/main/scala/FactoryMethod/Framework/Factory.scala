package FactoryMethod.Framework

abstract class Factory {

  def createProduct(owner: String): Product

  def registerProduct(product: Product): Unit
}
