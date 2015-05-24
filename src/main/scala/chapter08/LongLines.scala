package chapter08

import scala.io.Source

object LongLines {
  def processFile(filename: String, width: Int) {
    def processLine(line: String) {
      if (line.length > width) {
        println(s"$filename: $line")
      }
    }
    for (line <- Source.fromFile(filename).getLines()) {
      processLine(line)
    }
  }

  def main(args: Array[String]) {
    LongLines.processFile(".gitignore", 25)
  }
}
