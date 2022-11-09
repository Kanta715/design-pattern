package Prototype

import Prototype.Framework.{ Manager, Product }

object Main {

  /**
   * 以下の記事でわかったこととして、似たような処理のために都度コンストラクタでインスタンスを生成するのとしないのでは処理の重さが異なるため
   * copy メソッドを使ってインスタンスを生成する方が処理は軽くなるというメリットを理解した
   * https://www.macky-studio.com/entry/2019/05/30/163310
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

        // 問2
        val messageBoxForAnswer:   MessageBox   = MessageBox  ('_')
        val underlinePenForAnswer: UnderlinePen = UnderlinePen('_')
        println(messageBoxForAnswer  .messageBoxCopy  .decoChar)
        println(underlinePenForAnswer.underlinePenCopy.underline)
    }
  }
}
