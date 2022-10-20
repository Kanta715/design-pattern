// FilePropertiesクラスを実装
package Adapter.Anser

import java.util.Properties
import java.io.{ Reader, Writer, FileReader, FileWriter, IOException }

object FileProperties extends FileIO {

  val properties: Properties = new Properties

  override def readFromFile(filename: String): Unit =
    properties.load(new FileReader(filename))

  override def writeToFile(filename: String): Unit =
    properties.store(new FileWriter(filename), "TEST")

  override def setValue(key: String, value: String): Unit =
    properties.setProperty(key, value)

  override def getValue(key: String): String =
    properties.getProperty(key)
}
