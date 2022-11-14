package AbstractFactory.DivFactory

import AbstractFactory.Factory.Link

case class DivLinkFactory(caption: String, url: String) extends Link(caption, url) {

  def makeHTML: String = s"<div><a href=$url>$caption</a></div>"
}
