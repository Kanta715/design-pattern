package Strategy

import scala.util.Random
import scala.collection.mutable.Map

object ProbStrategy extends Strategy {

  private val random:      Random              = Random
  private var currentHand: Hand                = Hand.getHand(random.nextInt(3))
  val         history:     Map[Hand, Seq[Int]] = Map(
    Hand.ROCK     -> Seq(1, 1, 1),
    Hand.SCISSORS -> Seq(1, 1, 1),
    Hand.PAPER    -> Seq(1, 1, 1)
  )

  override def nextHand: Hand = {
    val bet:           Int = random.nextInt(getPointTotals)
    val rockPoint:     Int = getPointTotalAtHand(Hand.ROCK)
    val scissorsPoint: Int = getPointTotalAtHand(Hand.SCISSORS)
    val hand: Hand = {
      if      (rockPoint <= bet)                   Hand.ROCK
      else if ((rockPoint + scissorsPoint <= bet)) Hand.SCISSORS
      else                                         Hand.PAPER
    }
    println(bet)
    println(rockPoint)
    println(rockPoint + scissorsPoint)
    currentHand = hand
    currentHand
  }

  private def getPointTotals: Int =
    history.map(_._2).toSeq.flatten.foldLeft(0) { case (init, point) =>
      init + point
    }

  private def getPointTotalAtHand(hand: Hand): Int = {
    history.get(hand).toSeq.flatten.foldLeft(0) { case (init, point) =>
      init + point
    }
  }

  override def study(win: Boolean): Unit =
    win match {
      case true  => updateHistory(1)
      case false => updateHistory(0)
    }

  private def updateHistory(num: Int): Unit = {
    val updateHistory = history.get(currentHand).getOrElse(Nil) :+ num
    history update (currentHand, updateHistory)
    println(history)
  }
}
