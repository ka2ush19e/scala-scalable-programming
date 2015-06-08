package chapter16

object HighOrderListOperation {
  def main(args: Array[String]) {
    val nums = List(1, 2, 3)
    val words = List("the", "quick", "brown", "fox")

    println("### mapping ###")
    println(s"nums.map(_ + 1): ${nums.map(_ + 1)}")
    println(s"words.map(_.length): ${words.map(_.length)}")
    println(s"words.map(_.toList): ${words.map(_.toList)}")
    println(s"words.flatMap(_.toList): ${words.flatMap(_.toList)}")
    println()

    println("### filter ###")
    println(s"nums.filter(_ < 2): ${nums.filter(_ < 2)}")
    println(s"nums.partition(_ % 2 == 0): ${nums.partition(_ % 2 == 0)}")
    println(s"nums.find(_ % 2 == 0): ${nums.find(_ % 2 == 0)}")
    println(s"nums.find(_ > 5): ${nums.find(_ > 5)}")
    println(s"List(1, 2, 3, -4, 5).takeWhile(_ > 0): ${List(1, 2, 3, -4, 5).takeWhile(_ > 0)}")
    println(s"List(1, 2, 3, -4, 5).dropWhile(_ > 0): ${List(1, 2, 3, -4, 5).dropWhile(_ > 0)}")
    println(s"List(1, 2, 3, -4, 5).splitAt(2): ${List(1, 2, 3, -4, 5).splitAt(2)}")
    println(s"List(1, 2, 3, -4, 5).span(_ > 0): ${List(1, 2, 3, -4, 5).span(_ > 0)}")
    println()

    println("### exists ###")
    println(s"nums.forall(_ > 0)}: ${nums.forall(_ > 0)}")
    println(s"nums.exists(_ < 0): ${nums.exists(_ < 0)}")

    println("### fold ###")
    println( s"""("" /* words)(_ + " " + _): ${("" /: words)(_ + " " + _)}""")
    println( s"""(words.head /: words.tail)(_ + " " + _): ${(words.head /: words.tail)(_ + " " + _)}""")

    def reverseLeft[T](xs: List[T]): List[T] = {
      (List[T]() /: xs)((ys, y) => y :: ys)
    }
    println(s"reverseLeft(List(1, 2, 3, -4, 5)): ${reverseLeft(List(1, 2, 3, -4, 5))}")
    println()

    println("### sort ###")
    println(s"List(1, 2, 3, -4, 5).sortWith(_ < _): ${List(1, 2, 3, -4, 5).sortWith(_ < _)}")
  }
}
