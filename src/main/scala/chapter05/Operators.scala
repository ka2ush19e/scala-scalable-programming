package chapter05

object Operators {
  def main(args: Array[String]) {
    println(-2)
    println(2.unary_-)

    println(1 & 3) // 0001 and 0011
    println(1 | 3) // 0001 or 0011
    println(1 ^ 3) // 0001 xor 0011

    println(-1 >> 31)
    println(-1 >>> 31)
    println(1 << 3) // 0001 -> 1000
    println(12 >> 1) // 1100 -> 0110

    println(1 == 1.0)
    println(1 == null)
    println(null == null) // not throw NullPointerException

    println(0 max 5)
  }
}
