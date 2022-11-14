package AbstractFactory.Factory

trait Item {

  val caption: String

  def makeHTML: String
}
