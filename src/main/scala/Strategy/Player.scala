package Strategy

case class Player(
  name:     String,
  strategy: Strategy
) {

  var winCount:  Int = 0
  var loseCount: Int = 0
  var gameCount: Int = 0

  def nextHand: Hand = strategy.nextHand

  def win: Unit = {
    strategy.study(true)
    gameCount += 1
    winCount  += 1
  }

  def lose: Unit = {
    strategy.study(false)
    gameCount += 1
    loseCount += 1
  }

  def even: Unit = gameCount += 1
}
