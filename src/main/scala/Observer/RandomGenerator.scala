package Observer

case class RandomGenerator(
  override val observers: Seq[Observer[RandomGenerator]],
  override val numbers:   Seq[Int]
) extends NumberGenerator[RandomGenerator](observers, numbers) {

  def add(observer: Observer[RandomGenerator]): RandomGenerator =
    RandomGenerator(observers :+ observer, numbers)

  def remove(observer: Observer[RandomGenerator]): RandomGenerator =
    RandomGenerator(observers.filterNot(_ == observer), numbers)

  override def fire: Unit = {
    val seq   = Seq(random, random, random, random, random, random, random, random)
    val added = seq.foldLeft(numbers)({ case (seq, num) =>
      val added = seq :+ num
      val nextState = RandomGenerator(observers, added)
      if (nextState.numbers != numbers) {
        notifyObservers(nextState)
      }
      added
    })
    added.foldLeft(added)({ case (seq, num) =>
      val removed   = seq.filterNot(_ == num)
      val nextState = RandomGenerator(observers, removed)
      if (nextState.numbers != numbers) {
        notifyObservers(nextState)
      }
      removed
    })
  }

  private def random: Int =
  scala.util.Random.nextInt(1000)
}
