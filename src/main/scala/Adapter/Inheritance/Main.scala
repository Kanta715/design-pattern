package Adapter.Inheritance

object Main {

  def main(args: Array[String]): Unit = {
    val DEFAULT_STRING = "  [ デフォルトの文字列 ]"
    val strSeq         = args.toSeq
    strSeq.isEmpty match {
      // 引数がない場合は、デフォルトの文字列を出力
      case true  =>
        /**
         * Main では Print トレイトしか知らない
         * PrintBanner の実装を変えても Main に影響しない
         */
        val printable: Print = PrintBanner(DEFAULT_STRING)
        printable.printWeek()
        printable.printStrong()
      case false => for {
        str <- strSeq
      } yield {
        val printable: Print = PrintBanner(str)
        printable.printWeek()
        printable.printStrong()
      }
    }
  }
}
