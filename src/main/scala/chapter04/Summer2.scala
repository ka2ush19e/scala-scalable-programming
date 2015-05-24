package chapter04

object Summer2 extends App {
  val strs = Array("Hello", "World")
  strs.map(ChecksumAccumulator.calculate).foreach(println)
}
