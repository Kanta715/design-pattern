package AbstractFactory.ListFactory

import AbstractFactory.Factory.{ Item, Tray }

case class ListTrayFactory(caption: String, tray: Seq[Item] = Seq.empty) extends Tray(caption, tray) {

  override def add(item: Item): Tray =
    ListTrayFactory(caption, tray :+ item)

  override def makeHTML: String = {
    val strBuilder: StringBuilder = new StringBuilder
    strBuilder.append(s"<p>$caption</p>\n")
    for {
      item <- tray
    } yield strBuilder.append(s"${item.makeHTML}\n")
    strBuilder.toString
  }
}
