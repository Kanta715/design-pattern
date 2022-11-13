package AbstractFactory.Factory

abstract class Tray(
  caption: String,
  tray:    Seq[Item]
) extends Item {

  def add(item: Item): Tray
}
