package Visitor

object Main {
  def main(args: Array[String]): Unit = {
    val fileA = File("File-A", 1000)
    val fileB = File("File-B", 2000)
    val dir   = Directory("Directory-A", 0, Nil).add(fileA).add(fileB)

    val fileC = File("File-C", 300)
    val fileD = File("File-D", 50000)
    val fileE = File("File-E", 3500)

    val root = Directory("root", 0, Nil).add(dir).add(fileC).add(fileD).add(fileE)

    root.accept(ListVisitor)
  }
}
