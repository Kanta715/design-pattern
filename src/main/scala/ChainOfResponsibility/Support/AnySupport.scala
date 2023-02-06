package ChainOfResponsibility.Support
import ChainOfResponsibility.Trouble.Trouble

case class AnySupport(
  override val name: String = "なんでもサポート",
  override val next: Option[Support] = None
) extends Support(name, next) {

  override def resolve(trouble: Trouble): Boolean =
    trouble.number == 1000 ||
    trouble.number == 2000 ||
    trouble.number == 5000
}
