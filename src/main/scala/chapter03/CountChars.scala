package chapter03

import scala.io.Source

object CountChars {
  def main(args: Array[String]) {
    for (line <- Source.fromFile("src/main/resources/countchars.txt").getLines()) {
      println(line.length)
    }
    println()

    val lines = Source.fromFile("src/main/resources/countchars.txt").getLines().toList

    def widthOfLength(s: String): Int = s.length.toString.length

    val longestLine = lines.reduceLeft((a, b) => if (a.length > b.length) a else b)
    val maxWidth = widthOfLength(longestLine)
    println(s"maxWidth: $maxWidth")
    for (line <- lines) {
      val numSpaces = maxWidth - widthOfLength(line)
      val padding = " " * numSpaces
      println(padding + line.length)
    }

  }
}
