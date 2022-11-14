package AbstractFactory.DivFactory

import AbstractFactory.Factory.{ Item, Page }

case class DivPageFactory(
  title:   String,
  author:  String,
  content: Seq[Item]
) extends Page(title, author, content) {

  def add(item: Item): Page =
    DivPageFactory(title, author, content :+ item)

  def makeHTML: String = {
    val strBuilder: StringBuilder = new StringBuilder
    strBuilder.append("<!DOCTYPE html>\n")
    strBuilder.append("<html><head>")
    strBuilder.append(s"<title>$title</title>")
    strBuilder.append("<style>\n")
    strBuilder.append("div { padding-left: 8px; color: #CDA250; }\n")
    strBuilder.append("footer { margin-top: 16px; background: #CDA250; font-size: 8px; }\n")
    strBuilder.append("</style\n")
    strBuilder.append("</head>\n")
    strBuilder.append("<body>\n")
    strBuilder.append(s"<h1>$title</h1>\n")

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

