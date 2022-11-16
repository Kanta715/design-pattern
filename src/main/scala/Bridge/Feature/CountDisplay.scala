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

  def increasingDisplay(num: Int): Unit = {
    for (n <- 0 to num) {
      open
      for (_ <- 1 to n) {
        print
      }
      close
    }
  }
}
