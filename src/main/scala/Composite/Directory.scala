package Composite

case class Directory(override val name: String, directory: Seq[Entry] = Seq.empty) extends Entry(name) {

  override def getSize: Int =
    directory.map(_.getSize).sum

  override def printInfo: Unit = {
    print(s"$name($getSize)/")
    for {
      entry <- directory
    } entry.printInfo
    println()
  }

  /**
   * Scala では不変の変数を使うのがデフォルトのため、新しいインスタンスを生成して返すようにしている
   * 同じ名前のものが追加される場合は、新しいものに更新する
   */
  def addOrUpdate(entry: Entry): Directory = {
    val removed = directory.filterNot(_.name == entry.name)
    val added   = removed :+ entry
    Directory(name, added)
  }
}
