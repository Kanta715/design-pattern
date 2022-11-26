package Strategy

import scala.util.Random

/**
 * 負けない限り同じ手を出す Strategy の具象クラス
 */
object WinningStrategy extends Strategy {

  private val random:   Random  = Random
  private var won:      Boolean = false
  private var prevHand: Hand    = Hand.getHand(random.nextInt(3))

  override def nextHand: Hand = {
    if (!won) {
      prevHand = Hand.getHand(random.nextInt(3))
    }
    prevHand
  }

  override def study(win: Boolean): Unit = won = win

}
