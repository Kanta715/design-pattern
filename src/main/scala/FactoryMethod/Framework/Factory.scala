package FactoryMethod.Framework

abstract class Factory {

  def createProduct: Product

  def registerProduct(product: Product): Unit
}
