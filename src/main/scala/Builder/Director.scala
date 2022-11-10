package Builder

/**
 * Director は Builder という抽象型しかしらない
 * 具象型に依存してないため、Builder 型であれば全て扱える
 */
case class Director(builder: Builder) {

  def build(
    title:     String,
    paragraph: String,
    items:     Seq[String]
  ): Unit = {
    builder.makeTitle(title)
    builder.makeParagraph(paragraph)
    builder.makeItems(items)
    builder.close
  }
}
