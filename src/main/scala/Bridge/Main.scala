package Bridge

import scala.util.Random
import Bridge.Feature.{ CountDisplay, Display, RandomDisplay }
import Bridge.Implemetation.{ DisplayImpl, DecorationDisplayImpl, FileReadDisplayImpl, StringDisplayImpl }

/**
 * 機能のクラス階層と実装のクラス階層を分けることで、各クラス階層で機能拡張がしやすい
 */
object Main {

  def main(args: Array[String]): Unit = {
    val strOpt: Option[String] = args.headOption
    strOpt match {
      case Some(str) =>
        val random:        Random        = Random
        val number:        Int           = random.nextInt(20)
        val strImpl:       DisplayImpl   = StringDisplayImpl(str)
        val display:       Display       = new Display(strImpl)
        val countDisplay:  CountDisplay  = CountDisplay(strImpl)
        val randomDisplay: RandomDisplay = RandomDisplay(strImpl)

        display.display

        println
        countDisplay.display

        println
        countDisplay.multiDisplay(number)

        println
        // 問1
        randomDisplay.randomDisplay(number)

        println
        // 問2
        val fileReadDisplayImpl: DisplayImpl = FileReadDisplayImpl("src/main/scala/Builder/design-pattern.html")
        val fileDisplay:         Display     = new Display(fileReadDisplayImpl)
        fileDisplay.display

        println
        // 問3
        val decorationDisplayImpl:   DisplayImpl  = DecorationDisplayImpl('/', '-', '\\')
        val randomDecorationDisplay: CountDisplay = CountDisplay(decorationDisplayImpl)
        randomDecorationDisplay.increasingDisplay(number)

      case None      => throw new IllegalArgumentException("引数を指定してください")
    }
  }
}
