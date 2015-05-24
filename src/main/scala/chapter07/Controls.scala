package chapter07

object Controls {
  def main(args: Array[String]) {
    println(
      "2" match {
        case "1" => "one"
        case "2" => "two"
        case "3" => "three"
        case _ => "other"
      }
    )
  }
}
