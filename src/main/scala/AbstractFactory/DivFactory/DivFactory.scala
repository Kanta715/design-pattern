package AbstractFactory.DivFactory

import AbstractFactory.Factory.{ Factory, Item, Link, Page, Tray }

object DivFactory extends Factory {

  override def createLink(caption: String, url: String):                      Link = DivLinkFactory(caption, url)
  override def createTray(caption: String):                                   Tray = DivTrayFactory(caption)
  override def createPage(title: String, author: String, content: Seq[Item]): Page = DivPageFactory(title, author, content)
}
