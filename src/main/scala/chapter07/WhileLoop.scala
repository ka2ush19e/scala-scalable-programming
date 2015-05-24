package chapter07

object WhileLoop {
  def main(args: Array[String]) {
    def strs = Array("Hello", "Scala")
    println(if (strs.nonEmpty) strs(0) else "Bye")

    def gcdWhile(x: Long, y: Long): Long = {
      var a = x
      var b = y
      while (a != 0) {
        val temp = a
        a = b % a
        b = temp
      }
      b
    }


    def gcd(x: Long, y: Long): Long = {
      if (y == 0) x else gcd(y, x % y)
    }

    println(gcdWhile(12, 32))
    println(gcd(12, 32))
  }
}
