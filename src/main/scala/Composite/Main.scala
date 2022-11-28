package Composite

object Main {

  /**
   * Scala では基本的に不変な変数を使うため、シングルトンではなく都度新しいインスタンスを生成するようにしている
   */
  def main(args: Array[String]): Unit = {
    val rootDirectory = Directory("root")
    // ----------------------------------
    val viFile        = File("vi",    1000)
    val latexFile     = File("latex", 1000)
    val binDirectory  = Directory("bin").addOrUpdate(viFile).addOrUpdate(latexFile)
    // -----------------------------------
    val tmpDirectory  = Directory("tmp")
    // -----------------------------------
    val dailyHTMLFile = File("dialy.html", 2500)
    val compositeFile = File("Composite.java", 30000)
    val kanDirectory  = Directory("kan").addOrUpdate(dailyHTMLFile).addOrUpdate(compositeFile)

    val memoFile      = File("memo.txt", 1500)
    val nagiDirectory = Directory("nagi").addOrUpdate(memoFile)

    val gameFile      = File("game.doc", 40000)
    val mailFile      = File("junk.mail", 2000)
    val shinDirectory = Directory("shin").addOrUpdate(gameFile).addOrUpdate(mailFile)

    val usrDirectory  = Directory("usr").addOrUpdate(kanDirectory).addOrUpdate(nagiDirectory).addOrUpdate(shinDirectory)

    val updatedDirectory = rootDirectory.addOrUpdate(binDirectory).addOrUpdate(tmpDirectory).addOrUpdate(usrDirectory)

    println("[ Project structure ] -------------------")
    println
    updatedDirectory.printInfo
    println
    println("-----------------------------------------")
  }
}
