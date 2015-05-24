package chapter04

object Summer1 {
  def main (args: Array[String]) {
    val strs = Array("Hello", "World")
    strs.map(ChecksumAccumulator.calculate).foreach(println)
  }
}
