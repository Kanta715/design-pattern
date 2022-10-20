package Iterator

import java.util.Iterator

/**
 * 本棚を表すクラス
 */
case class BookShelf(
  books:        Seq[Book],
  var booksNum: Int        = 0 // Scala ではデフォルトで val になっているため、明示的に var にする
) extends java.lang.Iterable[Book] {

  /**
   * Iterable の iterator メソッドをオーバーライド
   */
  override def iterator(): Iterator[Book] = BookShelfIterator(this)

  /**
   * 本を追加するメソッド
   */
  def add(book: Book): Unit = {
    books :+ book
    this.booksNum = booksNum + 1
  }
}
