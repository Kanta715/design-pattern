package Observer

case class NumberObserver(tag: String = "[ Number Observer ]") extends Observer[RandomGenerator] {

  override def update(notify: RandomGenerator): Unit = {
    val numbers = notify.numbers
    val count   = notify.numbers.size

    Thread.sleep(1000)
    println(tag)
    count == 0 match {
      case true  =>
        println("NO DATA")
      case false =>
        for {
          _ <- numbers
        } yield {
          print("*")
        }
        println()
    }
  }
}
