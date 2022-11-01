package FactoryMethod.Framework

abstract case class Factory(owner: String) {

  def createProduct: Product

  def registerProduct(product: Product): Unit
}
