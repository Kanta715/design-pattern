package Observer

object Main {

  def main(args: Array[String]): Unit = {
    val observer  = NumberObserver()
    val random    = RandomGenerator(Seq(observer), Seq())
    random.fire
  }
}
