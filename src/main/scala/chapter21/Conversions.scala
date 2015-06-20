package chapter21

object Conversions {
  def main(args: Array[String]) {
    val d: Double = 3.5

  }

  implicit private def doubleToInt(d: Double): Int = d.toInt

}
