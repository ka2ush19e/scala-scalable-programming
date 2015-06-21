package chapter26

object RegularExpression {
  def main(args: Array[String]) {
    val Decimal = """(-)?(\d+)(\.\d+)?""".r

    println(Decimal.findFirstIn("foo 1.0 bar -100"))
    println(Decimal.findAllIn("foo 1.0 bar -100").toList)
    println(Decimal.findPrefixOf("foo 1.0 bar -100"))
    println(Decimal.findPrefixOf("1.0 bar -100"))

    val Decimal(sign, integer, decimal) = "-8934.3439"
    println(s"sign: $sign")
    println(s"integer: $integer")
    println(s"decimal: $decimal")
  }
}
