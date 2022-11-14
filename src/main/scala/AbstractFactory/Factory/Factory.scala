package AbstractFactory.Factory

abstract class Factory {

  def createLink(caption: String, url: String):                        Link
  def createTray(caption: String):                                     Tray
  def createPage(title:   String, author: String, content: Seq[Item]): Page
}
