package Singleton

class SingletonClass {

  val CONSTANT: String = "クラス: シングルトンオブジェクトではない"

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
