package Singleton

object SingletonObject {

  val CONSTANT: String = "オブジェクト: シングルトンオブジェクト"

  var count: Int = 0

  def +(num: Int): Int = {
    count = count + num
    count
  }

  def -(num: Int): Int = {
    count = count - num
    count
  }
}
