package chapter20

object Direction extends Enumeration {
  val North, East, South, West = Value

  def main(args: Array[String]) {
    Direction.values.foreach(d => println(s"${d.id} $d"))
    println()

    println(Direction(0))
  }
}
