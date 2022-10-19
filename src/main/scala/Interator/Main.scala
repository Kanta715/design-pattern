package Interator

import java.util.Iterator

object Main {

  // 1つ以上の本を渡す
  def main(books: Array[String]): Unit = {
    val bookNum = books.length
    bookNum > 0 match {
      case true =>

        // 本の配列
        val bookSeq = books.toSeq.map(book => Book(book))
        // 本棚

        val bookShelf = BookShelf(bookSeq, bookNum)

        val shelfIterator: Iterator[Book] = bookShelf.iterator()
        // Iterator を明示的に使う
        /**
         * この実装をする旨味は、ここで行っている while での処理において、
         * hasNext, next は、BookShelfIterator に依存していないこと。
         * この while 文は、java.util.Iterator を継承しているクラスであればどのクラスでも置き換え可能
         */
        println("---------[ Iterator ]---------------------")
        println("")
        while (shelfIterator.hasNext) {
          val book = shelfIterator.next
          println(book)
        }
        println("")

        // scala の for 式
        /**
         * こっちの方が完結で楽
         * hasNext, next がやっていることを裏側でやってくれている
         */
        println("---------[ Scala の拡張 for 式 ]-----------")
        println("")
        for {
          book <- bookShelf.books
        } yield println(book)

      // 引数がない場合、エラーを返す
      case false => throw new IllegalArgumentException("ERROR: 本の名前が見当たりません")
    }
  }
}
