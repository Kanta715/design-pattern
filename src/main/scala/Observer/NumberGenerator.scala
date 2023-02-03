package Observer

abstract class NumberGenerator[A <: Notify](
  val observers: Seq[Observer[A]],
  val numbers:   Seq[Int]
) extends Notify {

  def notifyObservers(notify: A): Unit =
    for {
      observer <- observers
    } yield observer.update(notify)
}








