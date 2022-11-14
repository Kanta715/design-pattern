package Singleton.Answer

sealed abstract class Triple(val name: String)

object TripleEnum {

  case object ALPHA extends Triple(name = "ALPHA")
  case object BETA  extends Triple(name = "BETA")
  case object GAMMA extends Triple(name = "GAMMA")

  val values = Seq(ALPHA, BETA, GAMMA)

  def getInstance(name: String): Triple =
    values.find(_.name == name) match {
      case Some(enum) => enum
      case None       => throw new IllegalArgumentException("指定された名前の列挙は存在しません")
    }
}
