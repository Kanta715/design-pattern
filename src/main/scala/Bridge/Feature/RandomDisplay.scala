package Bridge.Feature

import scala.util.Random
import Bridge.Implemetation.DisplayImpl

case class RandomDisplay(impl: DisplayImpl) extends Display(impl) {

  def randomDisplay(num: Int): Unit = {
    val random: Random = Random
    open
    for (n <- 1 to random.nextInt(num)) {
      print
    }
    close
  }
}
