package chapter16

object ListObjectOperation {
  def main(args: Array[String]) {
    println(s"List.range(1, 9): ${List.range(1, 9)}")
    println(s"List.range(1, 9, 2): ${List.range(1, 9, 2)}")
    println(s"List.fill(10)(5): ${List.fill(10)(5)}")
    println(s"List.tabulate(5)(_ + 5): ${List.tabulate(5)(_ + 5)}")
    println(s"List.tabulate(5, 5)(_ * _): ${List.tabulate(5, 5)(_ * _)}")
  }
}
