package Strategy.Answer

import java.util.Comparator

object ListStringSort {

  // Java で実装
  def atJava(isAsc: Boolean = true): Comparator[String] = {
    val comparator = new Comparator[String]() {
      override def compare(data: String, data2: String): Int =
        data.compareTo(data2)
    }
    if (!isAsc) comparator.reversed() else comparator
  }

  implicit object AtScala extends Ordering[String] {
    def compare(data: String, data2: String): Int =
      data.compareTo(data2)
  }
}
