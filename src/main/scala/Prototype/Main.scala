package Prototype

import Prototype.Framework.{ Manager, Product }

object Main {

  /**
   * 旨味としては Manager が、ある瞬間に生成した Productインスタンスを保持してくれていること
   */
  def main(args: Array[String]): Unit = {
    args.isEmpty match {
      case true  => throw new IllegalArgumentException("引数が見当たりません")
      case false =>
        val messageBox:    Product = MessageBox('=')
        val messageBox2:   Product = MessageBox('*')
        val messageBox3:   Product = MessageBox('!')
        val underlinePen:  Product = UnderlinePen('-')
        val underlinePen2: Product = UnderlinePen('~')
        val products: Seq[(String, Product)] = Seq(
          ("ボックス1",      messageBox),
          ("ボックス2",      messageBox2),
          ("ボックス3",      messageBox3),
          ("アンダーライン1", underlinePen),
          ("アンダーライン2", underlinePen2)
        )
        val manager: Manager = products.foldLeft(Manager(): Manager) { case (manager, product) =>
          manager.register(product._1, product._2)
        }
        for {
          message <- args
        } yield {
          val box:          Product = manager.find("ボックス2")
          val underlinePen: Product = manager.find("アンダーライン2")
          box         .use(message)
          underlinePen.use(message)
        }
    }
  }
}
