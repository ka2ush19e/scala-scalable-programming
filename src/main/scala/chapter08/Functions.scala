package chapter08

object Functions {
  def main(args: Array[String]) {
    val increase = (x: Int) => {
      println("Hello")
      x + 1
    }
    println(increase(10))
    println()

    val nums = (1 to 10).toList
    println(nums.filter((x: Int) => x % 2 == 0))
    println(nums.filter((x) => x % 2 == 0))
    println(nums.filter(x => x % 2 == 0))
    println(nums.filter(_ % 2 == 0))
    println()

    var f = (x: Int, y: Int) => x + y
    println(f(1, 2))
    f = (_: Int) + (_: Int)
    println(f(1, 2))
    println()

    def sum(a: Int, b: Int, c: Int) = a + b + c
    println(sum(1, 2, 3))
    val a = sum _
    println(a(1, 2, 3))
    println(a.apply(1, 2, 3))
    val b = sum(1, _: Int, 3)
    println(b(2))
    println()

    var more = 10
    val addMore = (x: Int) => more + x
    println(addMore(1))
    more = 10000
    println(addMore(1))
    println()

    def makeIncreaser(more: Int) = (x: Int) => x + more
    val inc1 = makeIncreaser(1)
    val inc9999 = makeIncreaser(9999)
    println(inc1(2))
    println(inc9999(2))
    println()

    def echo(strs: String*) = strs.foreach(println)
    echo()
    echo("Hello", "World")
    echo (Array("Hello", "Scala"): _*)
    println()

    Thread.sleep(1)

    def boom1(x: Int): Int = {
      if (x == 0) throw new Exception("boom1")
      else boom1(x - 1) + 1
    }
    try {
      boom1(3)
    } catch {
      case e: Exception => e.printStackTrace()
    }
    def boom2(x: Int): Int = {
      if (x == 0) throw new Exception("boom2")
      else boom2(x - 1)
    }
    try {
      boom2(3)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
