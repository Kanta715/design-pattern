package Adapter.Anser

import java.io.IOException

object Main {

  def main(args: Array[String]): Unit = {
    val keyOpt         = args.toSeq.headOption
    val fileIO: FileIO = FileProperties
    keyOpt match {
      case None =>
        try {
          fileIO.readFromFile("file.txt")
          fileIO.setValue("1", "[ Inoue Kanta ]")
          fileIO.setValue("2", "[ Hamashita Koki ]")
          fileIO.setValue("3", "[ Kitayama Daiki ]")
          fileIO.setValue("4", "[ Shimizu Takumi ]")
          fileIO.setValue("5", "[ Yasuoka Yusuke ]")
          fileIO.writeToFile("newfile.txt")
          println("Writing to newfile completed")
        } catch {
          case io: IOException => println(io.getMessage())
        }
      case Some(key) =>
        try {
          fileIO.readFromFile("newfile.txt")
          val value = fileIO.getValue(key)
          println(s"Get value: $value")
        } catch {
          case io: IOException => println(io.getMessage())
        }
    }
  }
}
