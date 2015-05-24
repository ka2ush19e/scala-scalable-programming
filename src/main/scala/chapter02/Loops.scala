package chapter02

object Loops {
  def main(args: Array[String]) {
    val strs = Array("Scala", "is", "fun")

    var i = 0
    while (i < strs.length) {
      println(strs(i))
      i += 1
    }
    println()

    strs.foreach(println)
    println()

    for (str <- strs) {
      println(str)
    }
    println()
  }
}
