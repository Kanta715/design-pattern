package ChainOfResponsibility.Support

import ChainOfResponsibility.Trouble.Trouble

abstract class Support(
  val name: String,
  val next: Option[Support] = None
) {

  def resolve(trouble: Trouble): Boolean

  def done(trouble: Trouble): Unit =
    println(s"$trouble is resolved by $name.")

  def fail(trouble: Trouble): Unit =
    println(s"$trouble cannot be resoled.($name)")

  def execute(trouble: Trouble): Unit =
    resolve(trouble) match {
      case true  => done(trouble)
      case false =>
        fail(trouble)
        next.foreach(_.execute(trouble))
    }
}
