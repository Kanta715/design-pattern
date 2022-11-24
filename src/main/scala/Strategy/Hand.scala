package Strategy

sealed abstract class Hand(val value: Int, val name: String) {

  def fight(hand: Hand): Int = {
    if      (this == hand)                       0
    else if ((this.value + 1) % 3 == hand.value) 1
    else                                         2
  }

  def isStrongerThan(hand: Hand): Boolean = fight(hand) == 1

  def isWeakerThan(hand: Hand): Boolean = fight(hand) == 2
}

object Hand {

  case object ROCK     extends Hand(0, "グー")
  case object SCISSORS extends Hand(1, "チョキ")
  case object PAPER    extends Hand(2, "パー")

  val values: Seq[Hand] = Seq(ROCK, SCISSORS, PAPER)

  def getHand(value: Int): Hand = values.find(_.value == value).getOrElse(Hand.ROCK)
}
