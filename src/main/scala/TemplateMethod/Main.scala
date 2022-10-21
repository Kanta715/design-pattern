package TemplateMethod

object Main {

  def main(args: Array[String]): Unit = {

    val DEFAULT_CHAR:   Char   = 'D'
    val DEFAULT_STRING: String = "DEFAULT STRING"
    /**
     * Char, String を取得
     */
    val char:   Char   = args.headOption.map(_.charAt(0)).getOrElse(DEFAULT_CHAR)
    val string: String = args.headOption.getOrElse(DEFAULT_STRING)

    /**
     * CharDisplay, StringDisplay を生成
     * Main は、AbstractDisplay 型であることしか知らない
     * Template Pattern に従い実装することで、似たような実装を共通化できる
     * バグが見つかった際はほとんど場合、Template クラス（スーパークラス）に原因があるため、バグの問題解決が容易になる
     */
    val charDisplay:   AbstractDisplay = CharDisplay(char)
    val stringDisplay: AbstractDisplay = StringDisplay(string)

    charDisplay.display
    stringDisplay.display
  }
}
