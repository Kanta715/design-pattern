package AbstractFactory.ListFactory

import AbstractFactory.Factory.{ Factory, Item, Link, Page, Tray }

object ListFactory extends Factory {

  override def createLink(caption: String, url: String):                      Link = ListLinkFactory(caption, url)
  override def createTray(caption: String):                                   Tray = ListTrayFactory(caption)
  override def createPage(title: String, author: String, content: Seq[Item]): Page = ListPageFactory(title, author, content)
}
