package AbstractFactory

import AbstractFactory.Factory.{ Factory => AbstractFactory, Item, Link, Page, Tray }
import AbstractFactory.ListFactory.{ ListFactory => ConcreteListFactory }
import AbstractFactory.DivFactory.{ DivFactory => ConcreteDivFactory }

object Main {

  def main(args: Array[String]): Unit = {

    val titleOpt: Option[String] = args.headOption

    val factoryWithTitle: (AbstractFactory, String) = titleOpt match {
      case Some(title @ "list") => (ConcreteListFactory, title)
      case Some(title @ "div")  => (ConcreteDivFactory, title)
      case None         => throw new IllegalArgumentException("引数を指定してください")
      case _            => throw new IllegalAccessException  ("list または div を指定してください")
    }
    val factory: AbstractFactory = factoryWithTitle._1

    val title:   String  = factoryWithTitle._2
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

  }
}
