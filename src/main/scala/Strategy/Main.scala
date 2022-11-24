package Strategy

object Main {

  def main(args: Array[String]): Unit = {
    if (args.length > 2) {
      throw new IllegalArgumentException("引数を2つ以上指定してください")
    }
    val name:  String = args.headOption.getOrElse("")
    val name2: String = args.lift(1)   .getOrElse("")

    val player:  Player = Player(name,  WinningStrategy)
    val player2: Player = Player(name2, ProbStrategy)

    for (_ <- 1 to 10000) {
      val hand  = player.nextHand
      Console.print(player.name)
      println(hand.name)
      val hand2 = player2.nextHand
      Console.print(player2.name)
      println(hand2.name)
      println
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
      println
      println
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
