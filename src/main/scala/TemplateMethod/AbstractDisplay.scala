package TemplateMethod

/**
 * Template の役割を担うクラス
 */
abstract class AbstractDisplay {

  val ITERATION_NUMBER = 5

  /**
   * サブクラスに具体的な実装は任せる
   */
  def open():  Unit
  def print(): Unit
  def close(): Unit

  /**
   * Template
   * サブクラスはこのメソッドを意識して実装する
   */
  final def display: Unit = {
    open()
    for (num <- 1 to ITERATION_NUMBER) {
      print()
    }
    close()
  }
}
