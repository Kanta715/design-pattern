package Builder.Director

import Builder.Abstract.Builder

/**
 * Director は Builder という抽象型しかしらない
 * 具象型に依存してないため、Builder 型であれば全て扱える
 */
case class Director(builder: Builder) {

  def build(
    title: String,
    paragraph: String,
    items: Seq[String]
  ): Unit = {
    builder.makeTitle(title)
    builder.makeParagraph(paragraph)
    builder.makeItems(items)
    builder.close
  }

  // 問2 Director の build メソッドを変える
  // 新しいメソッドを作ったが、TextBuilder, HTMLBuilder に影響はない
  def build(
    title: String,
    paragraph: String,
    items: Seq[String],
    paragraph2: String,
    items2: Seq[String]
  ): Unit = {
    builder.makeTitle(title)
    builder.makeParagraph(paragraph)
    builder.makeItems(items)
    builder.makeParagraph(paragraph2)
    builder.makeItems(items2)
    builder.close
  }
}
