package Composite

import Composite.Answer.{ Married, Single }

import java.time.LocalDate

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

    // -------------------------------------------------

    val naruto   = Married("うずまきナルト", LocalDate.of(2000, 5, 17))
    val boruto   = Single("うずまきボルト", LocalDate.of(2020, 8, 28))
    val himawari = Single("うずまきヒマワリ", LocalDate.of(2021, 9, 13))
    val minato   = Married("波風ミナト", LocalDate.of(1975, 11, 11)).add(naruto.add(boruto).add(himawari))

    minato.printInfo
  }
}
