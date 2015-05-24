package chapter03

object Arrays {
  def main(args: Array[String]) {
    val helloStrs1 = new Array[String](3)
    helloStrs1(0) = "Hello"
    helloStrs1(1) = ", "
    helloStrs1(2) = "World"
    0 to 2 foreach(i => print(helloStrs1(i)))
    println()

    val helloStrs2 = Array("Hello", ", ", "World")
    helloStrs2.foreach(print)
  }
}
