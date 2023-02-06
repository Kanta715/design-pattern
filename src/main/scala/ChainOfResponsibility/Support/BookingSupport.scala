package ChainOfResponsibility.Support
import ChainOfResponsibility.Trouble.Trouble

case class BookingSupport(
  override val name: String          = "予約サポート",
  override val next: Option[Support] = Some(CustomerSupport())
) extends Support(name, next) {

  override def resolve(trouble: Trouble): Boolean =
    trouble.number == 1000
}
