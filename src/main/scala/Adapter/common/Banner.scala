package Adapter.common

/**
 * 文字を出力するメソッドを持ったクラス
 */
class Banner(string: String) {

  def showWithParen: Unit = println(s"($string)")

  def showWithAster: Unit = println(s"*$string*")
}
