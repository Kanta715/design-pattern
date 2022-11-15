package Bridge

import scala.util.Random

import Bridge.Feature.{ CountDisplay, Display }
import Bridge.Implemetation.{ DisplayImpl, StringDisplayImpl }

/**
 * 機能のクラス階層と実装のクラス階層を分けることで、各クラス階層で機能拡張がしやすい
 */
object Main {

  def main(args: Array[String]): Unit = {
    val strOpt: Option[String] = args.headOption
    strOpt match {
      case Some(str) =>
        val strImpl:      DisplayImpl  = StringDisplayImpl(str)
        val display:      Display      = new Display(strImpl)
        val countDisplay: CountDisplay = CountDisplay(strImpl)
        val random:       Random       = Random

        display.display
        println("")
        countDisplay.display
        println("")
        countDisplay.multiDisplay(random.nextInt(20))
      case None      => throw new IllegalArgumentException("引数を指定してください")
    }
  }
}
