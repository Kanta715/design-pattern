package Singleton

sealed abstract class Sports(val name: String) {

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

object SingletonEnum {
  case object Baseball   extends Sports("野球")
  case object Soccer     extends Sports("サッカー")
  case object Basketball extends Sports("バスケットボール")

  def values: Seq[Sports] = Seq(Baseball, Soccer, Basketball)
}