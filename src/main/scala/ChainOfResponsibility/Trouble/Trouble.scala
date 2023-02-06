package ChainOfResponsibility.Trouble

sealed abstract class Trouble(val number: Int)

object Trouble {
  case object BookingTrouble extends Trouble(1000)
  case object PaymentTrouble extends Trouble(2000)
  case object SystemTrouble  extends Trouble(5000)
  case object UnknownTrouble extends Trouble(10000)

  val values: Seq[Trouble] = Seq(BookingTrouble, PaymentTrouble, SystemTrouble, UnknownTrouble)
}
