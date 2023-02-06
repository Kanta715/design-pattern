package ChainOfResponsibility.Support
import ChainOfResponsibility.Trouble.Trouble

case class CustomerSupport(
  override val name: String = "顧客サポート",
  override val next: Option[Support] = Some(AnySupport())
) extends Support(name, next) {

  override def resolve(trouble: Trouble): Boolean =
    trouble.number == 1000 || trouble.number == 2000
}
