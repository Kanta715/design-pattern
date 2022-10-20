package Iterator

import java.util.Iterator

/**
 * 本棚を操作するクラス
 */
case class BookShelfIterator(
  bookShelf: BookShelf,
  var index: Int        = 0 // Scalaでは、デフォルトで val になっているため、明示的に var にする
) extends Iterator[Book] {

  /**
   * 次の値があるかどうか判定に使用する
   */
  override def hasNext: Boolean =
    index < bookShelf.books.length

  /**
   * 次の値がある場合、index の値を変え、本を返す
   * ない場合、エラーを返す
   */
  override def next: Book =
    hasNext match {
      case true  =>
        val book = bookShelf.books(index)
        this.index = index + 1
        book
      case false =>
        throw new NoSuchElementException(s"この本棚は最大${bookShelf.books.length}冊です！！！")
    }
}
