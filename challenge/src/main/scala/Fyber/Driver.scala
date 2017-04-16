package Fyber

import scala.io.Source

/**
 * @author shahroz
 */
object Driver {

  case class Record(timestamp: Long, priceRatio: Double)

  def main(args: Array[String]): Unit = {

    val timeSeries = Source.fromFile(args(0)).getLines()

    printf(Constants.HEADER_FORMAT,
      Constants.NUM_SECONDS,
      Constants.PRICE_RATIO,
      Constants.NUM_MEASUREMENTS,
      Constants.ROLLING_SUM,
      Constants.MIN_PRICE_RATIO,
      Constants.MAX_PRICE_RATIO)

    println(Constants.HYPHENS)

    var listOfData = scala.collection.mutable.ListBuffer.empty[Record]
    timeSeries.foreach { record =>

      val inputElements = record.split(Constants.SPLITTER)
      val timestamp = inputElements(0).toLong
      val priceRatio = inputElements(1).toDouble

      listOfData = listOfData.filter { listRecord =>
        (timestamp - listRecord.timestamp) < Constants.RT_WINDOW
      }

      listOfData += Record(timestamp, priceRatio)

      val sum = listOfData.map(_.priceRatio).sum

      printf(Constants.HEADER_FORMAT,
        timestamp,
        priceRatio,
        listOfData.size,
        f"$sum%1.5f",
        listOfData.map(_.priceRatio).min,
        listOfData.map(_.priceRatio).max)

    }

  }

}