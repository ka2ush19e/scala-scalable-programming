package chapter03

object FunctionalStyles {
  def main(args: Array[String]) {
    val strs = Array("Scala", "is", "fun")

    var i = 0
    while (i < strs.length) {
      println(strs(i))
      i += 1
    }
    println()

    for (str <- strs) {
      println(str)
    }
    println()

    strs.foreach(println)
    println()

    def format(strs: Array[String]): String = strs.mkString("\n")
    println(format(strs))
  }
}
