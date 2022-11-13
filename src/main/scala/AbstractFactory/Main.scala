package AbstractFactory

import AbstractFactory.Factory.{ Factory, Item, Link, Page, Tray }
import AbstractFactory.ListFactory.ListFactory

object Main {

  def main(args: Array[String]): Unit = {

    val titleOpt: Option[String] = args.headOption

    titleOpt match {
      case Some(title @ "list") =>
        val factory: Factory = new ListFactory
        val author:  String  = "<a href=https://github.com/Kanta715>Kanta715</a>"

        val caption: String = "Design Pattern"
        val dLink:   Link   = factory.createLink("Iterator", "https://github.com/Kanta715/design-pattern/tree/main/java-sample/src/Iterator")
        val dLink2:  Link   = factory.createLink("Singleton", "https://github.com/Kanta715/design-pattern/tree/main/java-sample/src/Singleton")
        val dTray:   Tray   = factory.createTray(caption).add(dLink).add(dLink2)

        val caption2: String = "Company"
        val cLink:     Link  = factory.createLink("ネクストビート", "https://www.nextbeat.co.jp/")
        val cLink2:    Link  = factory.createLink("ママリ", "https://mamari.jp/")
        val cLink3:    Link  = factory.createLink("ネオキャリア", "https://www.neo-career.co.jp/")
        val cTray:     Tray  = factory.createTray(caption2).add(cLink).add(cLink2).add(cLink3)

        val content:   Seq[Item] = Seq(dTray, cTray)
        val page:      Page      = factory.createPage(title, author, content)
        page.output

      case Some("div")  => println("DIV")
      case None         => throw new IllegalArgumentException("引数を指定してください")
      case _            => throw new IllegalAccessException  ("list または div を指定してください")
    }
  }
}
