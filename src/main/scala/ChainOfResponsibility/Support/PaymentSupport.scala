package ChainOfResponsibility.Support
import ChainOfResponsibility.Trouble.Trouble

case class PaymentSupport(
  override val name: String          = "支払いサポート",
  override val next: Option[Support] = Some(CustomerSupport())
) extends Support(name, next) {

  override def resolve(trouble: Trouble): Boolean =
    trouble.number == 2000
}
