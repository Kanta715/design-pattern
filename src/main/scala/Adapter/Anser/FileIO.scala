package Adapter.Anser

import java.io.IOException

trait FileIO {

  @throws[IOException]
  def readFromFile(filename: String): Unit

  @throws[IOException]
  def writeToFile(filename: String): Unit

  def setValue(key: String, value: String): Unit

  def getValue(key: String): String
}
