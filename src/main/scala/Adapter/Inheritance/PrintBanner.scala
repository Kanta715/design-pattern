package Adapter.Inheritance

import Adapter.common.Banner

/**
 * 実際に Main で使うクラス
 */
case class PrintBanner(str: String) extends Banner(string = str) with Print {

  override def printWeek(): Unit = showWithParen

  override def printStrong(): Unit = showWithAster
}
