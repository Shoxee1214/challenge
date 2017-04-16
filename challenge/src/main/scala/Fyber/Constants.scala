package Fyber

/**
 * @author shahroz
 */
object Constants {

  val RT_WINDOW: Long = 60L

  val NUM_SECONDS: String = "T"
  val PRICE_RATIO: String = "V"
  val NUM_MEASUREMENTS: String = "N"
  val ROLLING_SUM: String = "RS"
  val MIN_PRICE_RATIO: String = "MinV"
  val MAX_PRICE_RATIO: String = "MaxV"

  val SECONDS_LENGTH: Int = 10
  val MEASUREMENTS_LENGTH: Int = 2
  val FLOAT_LENGTH: Int = 7
  val RS_LENGTH: Int = 8

  val HEADER_FORMAT = s"%-${SECONDS_LENGTH}s %-${FLOAT_LENGTH}s %-${MEASUREMENTS_LENGTH}s %-${RS_LENGTH}s %-${FLOAT_LENGTH}s %-${FLOAT_LENGTH}s\n"
  val HYPHENS = "-" * 46

  val SPLITTER: String = "\t"

}