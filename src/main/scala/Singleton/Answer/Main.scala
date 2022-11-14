package Singleton.Answer

import scala.concurrent.ExecutionContext
import java.util.concurrent.Executors
import scala.concurrent.Future

object Main {

  def main(args: Array[String]): Unit = {
    val ticketsNum: Int = args.length
    args.isEmpty match {
      case true  => throw new IllegalArgumentException("チケットが見当たりません")
      case false =>
        implicit val executionContext = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(10))
        for (num <- args) {
          println(num)
          Future {
            val random      = new java.util.Random
            val sleepTime   = random.nextInt(5000)
            val ticketMaker = TicketMaker
            Thread.sleep(sleepTime)
            println(ticketMaker)
            println(s"Asynchronous: $sleepTime: ${ticketMaker.getNextTicketNumber}")
          }
        }
        println("Synchronization")
        // Singleton.Anser.TicketMaker$@4f23ade2 <- 全て同じインスタンス
        // Asynchronous: 782: 1001
        // Singleton.Anser.TicketMaker$@4f23ade2
        // Asynchronous: 1882: 1002
        // Singleton.Anser.TicketMaker$@4f23ade2
        // Asynchronous: 2860: 1003
        // Singleton.Anser.TicketMaker$@4f23ade2
        // Asynchronous: 3141: 1004
        // Singleton.Anser.TicketMaker$@4f23ade2
        // Asynchronous: 3767: 1005
        // Singleton.Anser.TicketMaker$@4f23ade2
        // Asynchronous: 3847: 1006

        for {
          name <- args
        } {
          println(TripleEnum.getInstance(name))
        }
    }
  }
}
