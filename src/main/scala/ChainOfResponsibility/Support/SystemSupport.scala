package ChainOfResponsibility.Support
import ChainOfResponsibility.Trouble.Trouble

case class SystemSupport(
  override val name: String          = "システムサポート",
  override val next: Option[Support] = Some(AnySupport())
) extends Support(name, next) {

  override def resolve(trouble: Trouble): Boolean =
    trouble.number == 10000
}
