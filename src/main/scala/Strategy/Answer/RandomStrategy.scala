package Strategy.Answer

import scala.util.Random
import Strategy.{ Hand, Strategy }

/**
 * 問1: Random Strategy を作成
 */
object RandomStrategy extends Strategy {

  val random: Random = Random

  override def nextHand: Hand = Hand.getHand(random.nextInt(3))

  override def study(win: Boolean): Unit = println("永遠にランダムで出します")
}

