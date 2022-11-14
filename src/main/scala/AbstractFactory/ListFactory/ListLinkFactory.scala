package AbstractFactory.ListFactory

import AbstractFactory.Factory.Link

case class ListLinkFactory(caption: String, url: String) extends Link(caption, url) {

  def makeHTML: String = s"<li><a href=$url>$caption</a></li>"
}
