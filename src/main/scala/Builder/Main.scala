package Builder

import Builder.Abstract.Builder
import Builder.Director.{ Director => DIRECTOR }
import Builder.Concrete._

object Main {

  def main(args: Array[String]): Unit = {
    val fileTypeOpt: Option[String] = args.headOption

    val FILENAME:  String      = "design-pattern"
    val TITLE:     String      = "デザインパターン入門"
    val PARAGRAPH: String      = "デザインパターンリスト"
    val ITEMS:     Seq[String] = Seq("Iterator", "Adapter", "FactoryMethod", "TemplateMethod", "Singleton", "Prototype")

    val FILENAME2:  String      = "answer"
    val PARAGRAPH2: String      = "Builder Pattern"
    val ITEMS2:     Seq[String] = Seq("Builder")

    /**
     * Template パターンでは、Template(スーパークラス) 側でメソッドの扱いを制御している
     * Builder パターンでは、スーパークラスを扱う別のクラス(ここでいう Director)がスーパークラスの
     * メソッドを使ってサブクラスを制御する
     */
    try {
      fileTypeOpt match {
        case Some("text")   =>
          val textBuilder:  Builder  = TextBuilder.create(FILENAME)
          val textDirector: DIRECTOR = Builder.Director.Director(textBuilder)
          textDirector.build(TITLE, PARAGRAPH, ITEMS)
        case Some("html")   =>
          val htmlBuilder:  Builder  = HTMLBuilder.create(FILENAME)
          val htmlDirector: DIRECTOR = Builder.Director.Director(htmlBuilder)
          htmlDirector.build(TITLE, PARAGRAPH, ITEMS)
        case Some("answer") =>
          val htmlBuilder:  Builder  = HTMLBuilder.create(FILENAME2)
          val htmlDirector: DIRECTOR = Builder.Director.Director(htmlBuilder)
          htmlDirector.build(TITLE, PARAGRAPH, ITEMS, PARAGRAPH2, ITEMS2)
        case Some("md")    =>
          val mdBuilder:  Builder  = ReadMeBuilder.create(FILENAME)
          val mdDirector: DIRECTOR = Builder.Director.Director(mdBuilder)
          mdDirector.build(TITLE, PARAGRAPH, ITEMS)
        case _              =>
          throw new IllegalArgumentException("!!!!!!!!!!!  ERROR: 出力するファイルを指定してください  !!!!!!!!!!")
      }
    } catch {
      case e: Exception => println(e.getMessage)
    }
  }
}
