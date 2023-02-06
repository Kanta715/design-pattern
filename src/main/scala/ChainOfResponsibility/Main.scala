package ChainOfResponsibility

import ChainOfResponsibility.Support.BookingSupport

object Main {

  def main(args: Array[String]): Unit = {
    val bookingSupport = BookingSupport()

    for {
      trouble <- Trouble.Trouble.values
    } yield bookingSupport.execute(trouble)
  }
}
