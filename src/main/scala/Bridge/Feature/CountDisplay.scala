package Bridge.Feature

import Bridge.Implemetation.DisplayImpl

case class CountDisplay(impl: DisplayImpl) extends Display(impl) {

  def multiDisplay(num: Int): Unit = {
    open
    for (n <- 1 to num) {
      print
    }
    close
  }
}
