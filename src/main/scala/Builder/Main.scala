package Builder

object Main {

  def main(args: Array[String]): Unit = {
    val fileTypeOpt: Option[String] = args.headOption

    val FILENAME:  String      = "design-pattern"
    val TITLE:     String      = "デザインパターン入門"
    val PARAGRAPH: String      = "デザインパターンリスト"
    val ITEMS:     Seq[String] = Seq("Iterator", "Adapter", "FactoryMethod", "TemplateMethod", "Singleton", "Prototype")

    /**
     * Template パターンでは、Template(スーパークラス) 側でメソッドの扱いを制御している
     * Builder パターンでは、スーパークラスを扱う別のクラス(ここでいう Director)がスーパークラスの
     * メソッドを使ってサブクラスを制御する
     */
    fileTypeOpt match {
      case Some("text") =>
        val textBuilder:  Builder  = TextBuilder.create(FILENAME)
        val textDirector: Director = Director(textBuilder)
        textDirector.build(TITLE, PARAGRAPH, ITEMS)
      case Some("html") =>
        val htmlBuilder:  Builder  = HTMLBuilder.create(FILENAME)
        val htmlDirector: Director = Director(htmlBuilder)
        htmlDirector.build(TITLE, PARAGRAPH, ITEMS)
      case _            =>
        throw new IllegalArgumentException("text または html のファイルタイプを指定してください")
    }
  }
}
