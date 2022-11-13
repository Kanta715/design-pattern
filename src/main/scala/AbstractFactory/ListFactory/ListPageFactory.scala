package AbstractFactory.ListFactory

import AbstractFactory.Factory.{ Item, Page }

case class ListPageFactory(
  title:   String,
  author:  String,
  content: Seq[Item]
) extends Page(title, author, content) {

  def add(item: Item): ListPageFactory =
    ListPageFactory(title, author, content :+ item)

  def makeHTML: String = {
    val strBuilder: StringBuilder = new StringBuilder
    strBuilder.append("<!DOCTYPE html>\n")
    strBuilder.append("<html><head><title>")
    strBuilder.append(title)
    strBuilder.append("</title></head>\n")
    strBuilder.append("<body>\n")
    strBuilder.append("<h1>")
    strBuilder.append(title)
    strBuilder.append("</h1>\n")

    for {
      item <- content
    } yield strBuilder.append(s"${item.makeHTML}")

    strBuilder.append("\n")
    strBuilder.append("-----------------------------------------\n")
    strBuilder.append("<footer>\n")
    strBuilder.append(s"作者: $author\n")
    strBuilder.append("</footer>\n")
    strBuilder.append("</body></html>\n")

    strBuilder.toString
  }
}
