package Decorator

object Main {

  def main(args: Array[String]): Unit = {
    val string = "Kanta715"

    val side = SideBorder(StringDisplay(string))
    val full = FullBorder(FullBorder(FullBorder(FullBorder(side))))

    side.show

    full.show

    // |Kanta715|
    //
    // +----------------+
    // |+--------------+|
    // ||+------------+||
    // |||+----------+|||
    // |||||Kanta715|||||
    // |||+----------+|||
    // ||+------------+||
    // |+--------------+|
    // +----------------+
  }
}
