package Strategy

import scala.util.Random

object Main {

  def main(args: Array[String]): Unit = {
    if (args.length > 2) {
      throw new IllegalArgumentException("引数を2つ以上指定してください")
    }
    val name:  String = args.headOption.getOrElse("")
    val name2: String = args.lift(1)   .getOrElse("")

    val player:  Player = Player(name,  WinningStrategy)
    val player2: Player = Player(name2, ProbStrategy)

    val random: Random = Random
    for (_ <- 1 to random.nextInt(100)) {
      val hand  = player.nextHand
      println(hand.name)
      val hand2 = player2.nextHand
      println(hand2.name)
      if (hand.isStrongerThan(hand2)) {
        println(s"Winner!: ${player.name}")
        player .win
        player2.lose
      } else if (hand2.isStrongerThan(hand)) {
        println(s"Winner!: ${player2.name}")
        player .lose
        player2.win
      } else {
        println("Even...")
        player .even
        player2.even
      }
    }
    println
    println("----------------- TOTAL RESULT ------------------")
    println(s"Game Count: ${player.gameCount}")
    println
    println(s"Player: $player")
    println(s"Win Count: ${player.winCount}")
    println(s"Lose Count: ${player.loseCount}")
    println
    println(s"Player2: $player2")
    println(s"Win Count: ${player2.winCount}")
    println(s"Lose Count: ${player2.loseCount}")
  }
}
