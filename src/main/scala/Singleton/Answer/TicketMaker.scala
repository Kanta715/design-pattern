package Singleton.Answer

// TicketMaker.java を Singleton にする
object TicketMaker {
  var ticket = 1000

  // マルチスレッドで処理する際に、synchronized で処理することで競合を防ぐ
  def getNextTicketNumber: Int = synchronized {
    ticket += 1
    ticket
  }
}
