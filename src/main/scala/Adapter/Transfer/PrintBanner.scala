package Adapter.Transfer

import Adapter.common.Banner

/**
 * Banner にしたいことを任せる
 */
case class PrintBanner(banner: Banner) extends Print {

  override def printWeek(): Unit = banner.showWithParen

  override def printStrong(): Unit = banner.showWithAster
}

/**
 * コンパニオンオブジェクト
 */
object PrintBanner {

  /**
   * コンパニオンオブジェクトで Main から Banner を隠蔽
   */
  def create(string: String): PrintBanner = PrintBanner(new Banner(string))
}
