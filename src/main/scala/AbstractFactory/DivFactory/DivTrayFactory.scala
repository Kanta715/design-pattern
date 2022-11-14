package AbstractFactory.DivFactory

import AbstractFactory.Factory.{ Item, Tray }

case class DivTrayFactory(caption: String, tray: Seq[Item] = Seq.empty) extends Tray(caption, tray) {

  override def add(item: Item): Tray =
    DivTrayFactory(caption, tray :+ item)

  override def makeHTML: String = {
    val strBuilder: StringBuilder = new StringBuilder
    strBuilder.append(s"<div>$caption</div>\n")
    for {
      item <- tray
    } yield strBuilder.append(s"${item.makeHTML}\n")
    strBuilder.toString
  }
}
