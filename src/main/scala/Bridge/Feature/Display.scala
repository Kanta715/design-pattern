package Bridge.Feature

import Bridge.Implemetation.DisplayImpl

/**
 * 機能のクラス階層
 */
class Display(impl: DisplayImpl) {

  def open:  Unit = impl.rawOpen
  def print: Unit = impl.rawPrint
  def close: Unit = impl.rawClose

  final def display: Unit = {
    open
    print
    close
  }
}
