package Strategy

import scala.util.Random
import scala.collection.mutable.Map

object ProbStrategy extends Strategy {

  private val random:      Random              = Random
  private var prevHand:    Hand                = Hand.getHand(random.nextInt(3))
  private var currentHand: Hand                = Hand.getHand(random.nextInt(3))
  val         history:     Map[Hand, Seq[Int]] = Map(
    Hand.ROCK     -> Seq(1, 1, 1),
    Hand.SCISSORS -> Seq(1, 1, 1),
    Hand.PAPER    -> Seq(1, 1, 1)
  )

  override def nextHand: Hand = {
    val bet:    Int = random.nextInt(getPointTotalAtHand(currentHand))
    val point:  Int = history(currentHand).headOption.getOrElse(0)
    val point2: Int = history(currentHand).headOption.getOrElse(0) + history(currentHand).lift(1).getOrElse(0)
    val hand: Hand = {
      if      (bet < point)  Hand.ROCK
      else if (bet < point2) Hand.SCISSORS
      else                   Hand.PAPER
    }
    prevHand    = currentHand
    currentHand = hand
    hand
  }

  private def getPointTotalAtHand(hand: Hand): Int =
    history.get(hand).map(_.sum).getOrElse(0)

  override def study(win: Boolean): Unit = {
    val prevPoints = history.get(prevHand).getOrElse(Nil)
    win match {
      case true  =>
        val point = prevPoints(currentHand.value) + 1
        val list  = prevPoints.updated(currentHand.value, point)
        history update (prevHand, list)
      case false =>
        val point  = prevPoints((currentHand.value + 1) % 3) + 1
        val point2 = prevPoints((currentHand.value + 2) % 3) + 1
        val list   = prevPoints updated ((currentHand.value + 1) % 3, point)
        val list2  = prevPoints updated ((currentHand.value + 2) % 3, point2)
        history update (prevHand, list)
        history update (prevHand, list2)
    }
    println(history)
  }
}
